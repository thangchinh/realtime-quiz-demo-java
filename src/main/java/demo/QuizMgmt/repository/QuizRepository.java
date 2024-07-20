package demo.QuizMgmt.repository;

import demo.QuizMgmt.model.Quiz;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuizRepository extends MongoRepository<Quiz, String> {
  List<Quiz> findByQuizId(String quizId);
}
