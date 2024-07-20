package demo.ScoreMgmt.service;

import demo.BoardMgmt.service.BoardService;
import demo.QuizMgmt.dto.AnswersRequest;
import demo.ScoreMgmt.infra.event.ScoreEvent;
import demo.ScoreMgmt.util.ScoreUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScoreServiceImpl implements ApplicationEventPublisherAware, ScoreServive {

    private ApplicationEventPublisher applicationEventPublisher;
    private final BoardService boardService;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void updateScore(AnswersRequest answersRequest) {
        int updatedScore = ScoreUtil.calScore(answersRequest);
        var board = boardService.findBoardByQuizIdAndUserId(answersRequest.getQuizId(), answersRequest.getUserId());
        if (board != null) {
            board.setPoint(updatedScore);
            boardService.updateBoard(board);
        }
        publishScoreEvent(updatedScore, answersRequest.getUserId(), answersRequest.getQuizId());
    }

    private void publishScoreEvent(double score, String userId, String quizId) {
        ScoreEvent scoreEvent = ScoreEvent.builder().totalScore(score).userId(userId).quizId(quizId).build();
        applicationEventPublisher.publishEvent(scoreEvent);
    }
}
