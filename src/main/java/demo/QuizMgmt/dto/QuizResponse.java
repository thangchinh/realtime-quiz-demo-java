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

  public static QuizResponse fromQuiz(Quiz quiz) {
    if (quiz == null) {
      return null;
    }
    List<Question> questions = quiz.getQuestions();
    List<QuestionResponse> questionResponses = new ArrayList<>();
    for (Question question : questions) {
      QuestionResponse questionResponse = new QuestionResponse();
      questionResponse.setQuestion(question.getQuestion());
      questionResponse.setAnsA(question.getAnsA());
      questionResponse.setAnsB(question.getAnsB());
      questionResponse.setAnsC(question.getAnsC());
      questionResponse.setAnsD(question.getAnsD());
      questionResponses.add(questionResponse);
    }
    return new QuizResponse(questionResponses);
  }
}
