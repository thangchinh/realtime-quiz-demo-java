package com.example.realtime_quiz_demo.repository;

import com.example.realtime_quiz_demo.model.Quiz;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizRepository extends ReactiveMongoRepository<Quiz, String> {
}