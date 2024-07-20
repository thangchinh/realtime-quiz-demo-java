package demo.BoardMgmt.repository;

import demo.BoardMgmt.model.LeaderBoard;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<LeaderBoard, String> {
    LeaderBoard findByQuizIdAndUserId(String quizId, String userId);
    List<LeaderBoard> findByQuizIdOrderByPointDesc(String quizId);
}
