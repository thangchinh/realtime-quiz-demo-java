package demo.QuizMgmt.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Validated
public class Quiz {

    @Id
    private String quizId;

    @NotNull
    private List<@NotBlank(message = "questions must be present") Question> questions;
}
