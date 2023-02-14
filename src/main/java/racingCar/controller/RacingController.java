package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.util.RepeaterUtil;
import racingCar.view.InputView;
import racingCar.view.OutputView;
import java.util.List;

public class RacingController {

    private final RacingGame racingGame = new RacingGame();

    public void run() {
        List<String> carNames = RepeaterUtil.repeat(this::generateCars);
        int tryCount = RepeaterUtil.repeat(this::readTryCount);
        racingGame.play(carNames, tryCount);
        OutputView.printWinners(racingGame.findWinners());
    }

    private List<String> generateCars() {
        return RepeaterUtil.repeat(InputView::readCarNames);
    }

    private int readTryCount() {
        return RepeaterUtil.repeat(InputView::readTryCount);
    }
}
