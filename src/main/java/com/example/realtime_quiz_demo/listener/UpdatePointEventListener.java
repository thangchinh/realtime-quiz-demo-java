package com.example.realtime_quiz_demo.listener;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.realtime_quiz_demo.event.UpdatePointEvent;
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
    void handleAddEmployeeEvent(UpdatePointEvent event) {
        var leaderBoard = event.getLeaderBoard();
        log.info(event.toString());
        server.getRoomOperations(leaderBoard.getQuizId()).sendEvent("update_leader_board", leaderBoard);
    }
}