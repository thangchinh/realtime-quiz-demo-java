package demo.BoardMgmt.infra;

import com.corundumstudio.socketio.SocketIOServer;
import demo.ScoreMgmt.infra.event.ScoreEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdatePointEventListener {

    @Autowired
    private SocketIOServer server;

    @EventListener
    void handleAddEmployeeEvent(ScoreEvent event) {
        log.info("Publishing score event={}", event);
        server.getRoomOperations(event.getQuizId()).sendEvent("update_leader_board", event);
    }
}
