package demo.QuizMgmt.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class AnswersRequest {
    @NotBlank(message = "quizId must be present")
    private String quizId;

    @NotBlank(message = "userId must be present")
    private String userId;

    private Map<String, String> questionsAndAnswersMap;
}
