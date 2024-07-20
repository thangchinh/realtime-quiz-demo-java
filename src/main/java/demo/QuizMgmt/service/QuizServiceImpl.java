package demo.QuizMgmt.service;

import demo.QuizMgmt.dto.QuizResponse;
import demo.QuizMgmt.repository.QuizRepository;
import demo.QuizMgmt.model.Question;
import demo.QuizMgmt.model.Quiz;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService {

  @Autowired
  private QuizRepository quizRepository;

  @Override
  public Quiz addInitialData() {
    Quiz dummyQuiz = new Quiz("111",
      List.of(
        new Question("quest1", "ans1", "ans2", "ans3", "ans4", 1, 10),
        new Question("quest2", "ans1", "ans2", "ans3", "ans4", 2, 10),
        new Question("quest3", "ans1", "ans2", "ans3", "ans4", 3, 10)
      )
    );
    return quizRepository.save(dummyQuiz);
  }

  @Override
  public QuizResponse getQuizByRoomId(String roomId) {
    return QuizResponse.fromQuiz(quizRepository.findByQuizId(roomId));
  }
}
