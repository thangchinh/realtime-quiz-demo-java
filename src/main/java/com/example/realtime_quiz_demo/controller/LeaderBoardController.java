package com.example.realtime_quiz_demo.controller;

import com.example.realtime_quiz_demo.model.LeaderBoard;
import com.example.realtime_quiz_demo.service.LeaderBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/leader-board")
@Slf4j
public class LeaderBoardController {

    @Autowired
    private LeaderBoardService leaderBoardService;

    @PostMapping("/register-point")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LeaderBoard> registerPoint(@RequestBody LeaderBoard leaderBoard) {
        return leaderBoardService.registerPoint(leaderBoard);
    }

    @GetMapping("/get-leader-board")
    public Flux<LeaderBoard> getLeaderBoard(@RequestParam(value = "quizId", required = true) String quizId) {
        return leaderBoardService.getLeaderBoard(quizId);
    }
}
