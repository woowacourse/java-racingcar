package car;

import domain.RacingGame;
import java.util.List;
import view.InputView;
import view.OutputView;

public class GameController {

    private OutputView message = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        try {
            List<Car> carNames = inputView.getCarNames();
            int round = inputView.getRound();

            RacingGame racingGame = new RacingGame(carNames, round);
            racingGame.moveCar(carNames, round);
            racingGame.result();
        } catch (IllegalArgumentException error) {
            message.errorPrint();
            start();
        }
    }
}
