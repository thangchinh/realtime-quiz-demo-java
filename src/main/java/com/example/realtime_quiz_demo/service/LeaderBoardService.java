package com.example.realtime_quiz_demo.service;

import com.example.realtime_quiz_demo.model.LeaderBoard;
import com.example.realtime_quiz_demo.repository.LeaderBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class LeaderBoardService {

    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    public Mono<LeaderBoard> registerPoint(LeaderBoard leaderBoard) {
        return leaderBoardRepository
                .findByQuizIdAndUserId(leaderBoard.getQuizId(), leaderBoard.getUserId())
                .flatMap(existingRecord -> {
                    existingRecord.setPoint(leaderBoard.getPoint());
                    return leaderBoardRepository.save(existingRecord);
                })
                .switchIfEmpty(Mono.defer(() -> leaderBoardRepository.save(leaderBoard)));
    }

    public Flux<LeaderBoard> getLeaderBoard(String quizId){
        return  leaderBoardRepository.findByQuizIdOrderByPointDesc(quizId);
    }
}
