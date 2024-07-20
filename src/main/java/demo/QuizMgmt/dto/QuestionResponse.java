package demo.QuizMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
  private String question;

  private String ansA;

  private String ansB;

  private String ansC;

  private String ansD;

  private Integer correctAns;

}
