package demo.BoardMgmt.dto;

import demo.BoardMgmt.model.LeaderBoard;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderBoardResponse {
  private String quizId;

  private String userId;

  private Integer point;

  public static List<LeaderBoardResponse> fromModel(List<LeaderBoard> leaderBoards) {
    var result = new ArrayList<LeaderBoardResponse>();
    for (LeaderBoard leaderBoard : leaderBoards) {
      result.add(new LeaderBoardResponse(leaderBoard.getQuizId(), leaderBoard.getUserId(), leaderBoard.getPoint()));
    }
    return result;
  }
}
