package demo.BoardMgmt.controller;

import demo.BoardMgmt.dto.LeaderBoardResponse;
import demo.BoardMgmt.service.BoardService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leader-board")
@Slf4j
public class LeaderBoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/get-leader-board")
    public List<LeaderBoardResponse> getLeaderBoard(@RequestParam(value = "quizId") String quizId) {
        log.info("get-leader-board quizId={}", quizId);
        return boardService.getLeaderBoard(quizId);
    }
}
