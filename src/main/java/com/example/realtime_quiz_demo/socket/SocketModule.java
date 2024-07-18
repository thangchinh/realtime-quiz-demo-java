package com.example.realtime_quiz_demo.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.example.realtime_quiz_demo.model.LeaderBoard;
import com.example.realtime_quiz_demo.service.LeaderBoardService;
import com.example.realtime_quiz_demo.service.SocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SocketModule {

    private final SocketIOServer server;
    private final SocketService socketService;
    private final LeaderBoardService leaderBoardService;

    public SocketModule(SocketIOServer server, SocketService socketService, LeaderBoardService leaderBoardService) {
        this.server = server;
        this.socketService = socketService;
        this.leaderBoardService = leaderBoardService;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());

        server.addEventListener("update_point", LeaderBoard.class, (client, data, ackSender) -> {
            System.out.println("update point event");
            leaderBoardService.registerPoint(data)
                    .doOnSuccess(lb -> {
                        server.getRoomOperations(data.getQuizId()).sendEvent("update_leader_board", data);
                    })
                    .subscribe();
        });
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