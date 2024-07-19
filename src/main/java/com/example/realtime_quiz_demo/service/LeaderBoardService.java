package com.example.realtime_quiz_demo.service;

import com.example.realtime_quiz_demo.event.UpdatePointEvent;
import com.example.realtime_quiz_demo.model.LeaderBoard;
import com.example.realtime_quiz_demo.repository.LeaderBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeaderBoardService implements ApplicationEventPublisherAware {

    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public LeaderBoard registerPoint(LeaderBoard leaderBoard) {
        var updateLeaderBoard = leaderBoard;
        var currentLeaderBoard = leaderBoardRepository.findByQuizIdAndUserId(leaderBoard.getQuizId(), leaderBoard.getUserId());
        if (currentLeaderBoard != null) {
            currentLeaderBoard.setPoint(leaderBoard.getPoint());
            updateLeaderBoard = currentLeaderBoard;
        }
        updateLeaderBoard = leaderBoardRepository.save(updateLeaderBoard);
        applicationEventPublisher.publishEvent(new UpdatePointEvent(updateLeaderBoard));
        return updateLeaderBoard;
    }

    public List<LeaderBoard> getLeaderBoard(String quizId) {
        return leaderBoardRepository.findByQuizIdOrderByPointDesc(quizId);
    }
}
