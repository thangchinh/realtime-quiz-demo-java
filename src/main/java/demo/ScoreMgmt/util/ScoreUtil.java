package demo.ScoreMgmt.util;

import demo.QuizMgmt.dto.AnswersRequest;
import java.util.Random;

public class ScoreUtil {

  // For demo purpose, score is randomly calculated
  public static int calScore(AnswersRequest answersRequest) {
    Random random = new Random();
    return 1 + random.nextInt(100);
  }

  private ScoreUtil() {
    throw new RuntimeException("Cannot instantiate ScoreUtil");
  }
}
