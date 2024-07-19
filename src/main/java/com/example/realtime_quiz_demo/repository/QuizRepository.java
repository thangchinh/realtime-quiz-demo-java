package com.example.realtime_quiz_demo.repository;

import com.example.realtime_quiz_demo.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}