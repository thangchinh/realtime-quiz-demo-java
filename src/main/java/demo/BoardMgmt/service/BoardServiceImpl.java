package demo.BoardMgmt.service;

import demo.BoardMgmt.dto.LeaderBoardResponse;
import demo.BoardMgmt.model.LeaderBoard;
import demo.BoardMgmt.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<LeaderBoardResponse> getLeaderBoard(String quizId) {
        return LeaderBoardResponse.fromModel(boardRepository.findByQuizIdOrderByPointDesc(quizId));
    }

    @Override
    public LeaderBoard findBoardByQuizIdAndUserId(String quizId, String userId) {
        return boardRepository.findByQuizIdAndUserId(quizId, userId);
    }

    @Override
    @Transactional
    public void updateBoard(LeaderBoard leaderBoard) {
        boardRepository.save(leaderBoard);
    }

}
