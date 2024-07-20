package demo.QuizMgmt.controller;

import demo.QuizMgmt.dto.QuizResponse;
import demo.QuizMgmt.service.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
@Slf4j
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/quizs")
    public QuizResponse getQuizByRoom(@RequestParam String roomId) {
        log.info("getQuizByRoom={}", roomId);
        return quizService.getQuizByRoomId(roomId);
    }
}
