package com.example.realtime_quiz_demo.controller;

import com.example.realtime_quiz_demo.model.Quiz;
import com.example.realtime_quiz_demo.service.QuizService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@Slf4j
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/dummy-quiz")
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz addMovieInfo() {
        return quizService.addDummyQuiz();
    }

    @GetMapping("/quizs")
    public List<Quiz> getAllQuizs() {
        return quizService.getAllQuizs();
    }
}
