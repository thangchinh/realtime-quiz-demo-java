package com.example.realtime_quiz_demo.service;

import com.example.realtime_quiz_demo.model.Question;
import com.example.realtime_quiz_demo.model.Quiz;
import com.example.realtime_quiz_demo.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Mono<Quiz> addDummyQuiz() {
        Quiz dummyQuiz = new Quiz("111",
                List.of(
                        new Question("quest1", "ans1", "ans2", "ans3", "ans4", 1),
                        new Question("quest2", "ans1", "ans2", "ans3", "ans4", 2),
                        new Question("quest3", "ans1", "ans2", "ans3", "ans4", 3)
                )
            );
        return quizRepository.save(dummyQuiz)
                .log();
    }

    public Flux<Quiz> getAllQuizs(){
        return  quizRepository.findAll();
    }
}
