package demo.BoardMgmt.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Validated
@Builder
@CompoundIndex(name = "unique_quiz_user", def = "{'quizId': 1, 'userId': 1}", unique = true)
public class LeaderBoard {
    @Id
    private String id;

    @NotBlank(message = "quizId must be present")
    private String quizId;

    @NotBlank(message = "userId must be present")
    private String userId;

    @NotNull
    @Positive(message = "point must be a Positive Value")
    private Integer point;
}
