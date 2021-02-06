package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;
import racingcar.view.RacingCarView;

public class RacingCar {
    public static void run() {
        racingCarSetting();
        pickWinners();
        RacingCarView.printFinalResult(Winners.getWinnersNames());
    }

    private static void racingCarSetting() {
        Cars.assignCars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        GameRule gameRule = new GameRule();
        progressTryCount(tryCount, gameRule);
    }

    private static void progressTryCount(TryCount tryCount, GameRule gameRule) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            progressRacing(gameRule);
            RacingCarView.printProgressResult(Cars.getCars());
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
            carController.moveCar();
        }
    }

    private static void pickWinners() {
        Winners.setWinners(Cars.getCars());
    }
}
