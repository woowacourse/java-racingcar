package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.domain.TryCount;
import racingCar.util.RepeaterUtil;
import racingCar.view.InputView;
import racingCar.view.OutputView;
import java.util.List;

public class RacingController {

    private RacingGame racingGame;

    public void run() {
        List<String> carNames = RepeaterUtil.repeat(this::generateCars);
        TryCount tryCount = readTryCount();
        racingGame = new RacingGame(carNames);
        for (int count = 1; count <= tryCount.getTryCount(); count++) {
            OutputView.printRacing(racingGame.race());
        }
        OutputView.printWinners(racingGame.findWinners());
    }

    private List<String> generateCars() {
        return RepeaterUtil.repeat(InputView::readCarNames);
    }

    private TryCount readTryCount() {
        return new TryCount(RepeaterUtil.repeat(InputView::readTryCount));
    }
}
