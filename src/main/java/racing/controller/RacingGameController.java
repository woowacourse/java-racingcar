package racing.controller;

import racing.domain.CarRandomNumberGenerator;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final RacingGame racingGame;
    private final int tryCount;

    public RacingGameController() {
        List<String> carNames = InputView.inputCarNames();
        this.tryCount = InputView.inputTryCount();
        racingGame = new RacingGame(carNames, new CarRandomNumberGenerator());
    }

    public void run() {
        OutputView.printBeforeRacing();
        for (int i = 0; i < tryCount; i++) {
            racingGame.play();
            OutputView.printRacing(racingGame);
        }
        OutputView.printWinners(racingGame);
    }
}
