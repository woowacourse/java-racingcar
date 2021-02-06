package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCar {
    private static TryCount tryCount;
    private static GameRule gameRule;

    public static void run() {
        racingCarSetting();
        racing(tryCount, gameRule);
        pickWinners();
        RacingCarView.printFinalResult(Winners.getWinnersNames());
    }

    private static void racingCarSetting() {
        Cars.setCarsByName(getCarNames());
        tryCount = new TryCount(InputView.getTryCountInput());
        gameRule = new GameRule();
    }

    private static List<String> getCarNames() {
        return RacingCarUtils.splitInputString(InputView.getCarNameInput());
    }

    private static void racing(final TryCount tryCount, final GameRule gameRule) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            changeCarsStatus(gameRule);
            RacingCarView.printProgressResult(Cars.getCars());
        }
    }

    private static void changeCarsStatus(final GameRule gameRule) {
        for (Car car : Cars.getCars()) {
            moveMovableCar(car, gameRule);
        }
    }

    private static void moveMovableCar(final Car car, final GameRule gameRule) {
        CarController carController = new CarController(car);
        RandomNumber randomNumber = new RandomNumber();
        if (gameRule.isMoveNumber(randomNumber.getNumber())) {
            carController.carMove();
        }
    }

    private static void pickWinners() {
        Winners.setWinners();
    }
}
