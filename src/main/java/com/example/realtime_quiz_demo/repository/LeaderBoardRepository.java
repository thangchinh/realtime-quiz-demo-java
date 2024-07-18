package com.example.realtime_quiz_demo.repository;

import com.example.realtime_quiz_demo.model.LeaderBoard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LeaderBoardRepository extends ReactiveMongoRepository<LeaderBoard, String> {
    Mono<LeaderBoard> findByQuizIdAndUserId(String quizId, String userId);
    Flux<LeaderBoard> findByQuizIdOrderByPointDesc(String quizId);
}
