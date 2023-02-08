import domain.RacingGame;
import view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int count = InputView.readCount();
        RacingGame racingGame = new RacingGame(carNames, count);
        racingGame.start();
    }
}
