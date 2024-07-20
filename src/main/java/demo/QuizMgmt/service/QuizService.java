package demo.QuizMgmt.service;

import demo.QuizMgmt.dto.QuizResponse;
import demo.QuizMgmt.model.Quiz;
import java.util.List;

public interface QuizService {
  Quiz addInitialData();
  List<QuizResponse> getQuizByRoomId(String roomId);
}
