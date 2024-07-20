package demo.BoardMgmt.service;

import demo.BoardMgmt.dto.LeaderBoardResponse;
import demo.BoardMgmt.model.LeaderBoard;
import java.util.List;

public interface BoardService {

  List<LeaderBoardResponse> getLeaderBoard(String quizId);

  LeaderBoard findBoardByQuizIdAndUserId(String quizId, String userId);

  void updateBoard(LeaderBoard leaderBoard);
}
