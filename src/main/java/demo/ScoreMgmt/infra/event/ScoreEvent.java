package demo.ScoreMgmt.infra.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ScoreEvent {
    private String quizId;

    private String userId;

    private double totalScore;
}
