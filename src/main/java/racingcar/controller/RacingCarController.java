package racingcar.controller;

import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;

public class RacingCarController {
    public static void run() {
        racingCarSetting();
    }

    private static void racingCarSetting() {
        Cars.setCars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        GameRule gameRule = new GameRule();
        progressTryCount(tryCount, gameRule);
    }

    private static void progressTryCount(TryCount tryCount, GameRule gameRule) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            progressRacing(gameRule);
        }
    }

    private static void progressRacing(GameRule gameRule) {
        for (Car car : Cars.getCars()) {
            moveMovableCar(car, gameRule);
        }
    }

    private static void moveMovableCar(Car car, GameRule gameRule) {
        CarController carController = new CarController(car);
        RandomNumber randomNumber = new RandomNumber();
        if (gameRule.isMoveNumber(randomNumber.getNumber())) {
            carController.carMove();
        }
    }
}
