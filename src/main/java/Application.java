import java.util.List;
import racing.controller.GameController;
import racing.domain.RacingGame;
import racing.view.input.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarName();
        int tryCount = InputView.inputCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        GameController gameController = new GameController(racingGame);
        gameController.run();
    }
}
