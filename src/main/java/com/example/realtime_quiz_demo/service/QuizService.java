package com.example.realtime_quiz_demo.service;

import com.example.realtime_quiz_demo.model.Question;
import com.example.realtime_quiz_demo.model.Quiz;
import com.example.realtime_quiz_demo.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz addDummyQuiz() {
        Quiz dummyQuiz = new Quiz("111",
                List.of(
                        new Question("quest1", "ans1", "ans2", "ans3", "ans4", 1, 10),
                        new Question("quest2", "ans1", "ans2", "ans3", "ans4", 2, 20),
                        new Question("quest3", "ans1", "ans2", "ans3", "ans4", 3, 30)
                )
            );
        return quizRepository.save(dummyQuiz);
    }

    public List<Quiz> getAllQuizs(){
        return quizRepository.findAll();
    }
}
