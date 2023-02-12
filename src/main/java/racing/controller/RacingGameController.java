package racing.controller;

import racing.domain.CarRandomNumberGenerator;
import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final RacingGame racingGame;

    public RacingGameController() {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();
        racingGame = new RacingGame(new CarRandomNumberGenerator(), new Cars(carNames), tryCount);
    }

    public void run() {
        OutputView.printBeforeRacing();
        while (!racingGame.isEnd()) {
            racingGame.play();
            OutputView.printRacing(racingGame);
        }
        OutputView.printWinners(racingGame);
    }
}
