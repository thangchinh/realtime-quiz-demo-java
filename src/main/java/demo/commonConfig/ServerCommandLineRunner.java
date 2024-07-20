package demo.commonConfig;

import com.corundumstudio.socketio.SocketIOServer;
import demo.QuizMgmt.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOServer server;
    private final QuizService quizService;

    @Override
    public void run(String... args) throws Exception {
        server.start();
        quizService.addInitialData();
    }
}
