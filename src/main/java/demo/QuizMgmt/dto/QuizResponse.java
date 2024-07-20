package demo.QuizMgmt.dto;

import demo.QuizMgmt.model.Question;
import demo.QuizMgmt.model.Quiz;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {

  private List<QuestionResponse> questions;

  public static List<QuizResponse> fromQuiz(List<Quiz> quizs) {
    var result = new ArrayList<QuizResponse>();
    if (quizs != null) {
      for (Quiz quiz : quizs) {
        List<Question> questions = quiz.getQuestions();
        List<QuestionResponse> questionResponses = new ArrayList<>();
        for (Question question : questions) {
          QuestionResponse questionResponse = new QuestionResponse();
          questionResponse.setAnsA(question.getAnsA());
          questionResponse.setAnsB(question.getAnsB());
          questionResponse.setAnsC(question.getAnsC());
          questionResponses.add(questionResponse);
        }
        result.add(new QuizResponse(questionResponses));
      }
    }
    return result;
  }

}
