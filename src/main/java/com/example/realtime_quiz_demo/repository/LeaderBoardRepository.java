package com.example.realtime_quiz_demo.repository;

import com.example.realtime_quiz_demo.model.LeaderBoard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LeaderBoardRepository extends MongoRepository<LeaderBoard, String> {
    LeaderBoard findByQuizIdAndUserId(String quizId, String userId);
    List<LeaderBoard> findByQuizIdOrderByPointDesc(String quizId);
}
