package demo.BoardMgmt.infra.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import demo.BoardMgmt.service.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketModule {

  private final SocketIOServer server;
  private final BoardServiceImpl boardServiceImpl;

  public SocketModule(SocketIOServer server, BoardServiceImpl boardServiceImpl) {
    this.server = server;
    this.boardServiceImpl = boardServiceImpl;
    server.addConnectListener(onConnected());
    server.addDisconnectListener(onDisconnected());
  }

  private ConnectListener onConnected() {
    return (client) -> {
      String room = client.getHandshakeData().getSingleUrlParam("quizId");
      client.joinRoom(room);
      log.info("Socket ID[{}]  Connected to socket", client.getSessionId().toString());
    };
  }

  private DisconnectListener onDisconnected() {
    return client -> {
      log.info("Client[{}] - Disconnected from socket", client.getSessionId().toString());
    };
  }

}
