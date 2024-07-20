package demo.QuizMgmt.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Validated
public class Question {
    @NotBlank(message = "question must be present")
    private String question;

    @NotBlank(message = "answer A must be present")
    private String ansA;

    @NotBlank(message = "answer B must be present")
    private String ansB;

    @NotBlank(message = "answer C must be present")
    private String ansC;

    @NotBlank(message = "answer D must be present")
    private String ansD;

    @NotNull
    @Positive(message = "correctAns must be a Positive Value")
    private Integer correctAns;

    @NotNull
    @Positive(message = "questionPoint must be a Positive Value")
    private Integer questionPoint;
}
