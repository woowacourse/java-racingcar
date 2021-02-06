package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.io.InputView;
import racingcar.view.RacingCarView;

public class RacingCar {
    public static void run() {
        setUpRacingCar();
        selectWinners();
        RacingCarView.printFinalResult(Winners.getWinnersNames());
    }

    private static void setUpRacingCar() {
        Cars.assignCars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        GameRule gameRule = new GameRule();
        progressTryCount(tryCount, gameRule);
    }

    private static void progressTryCount(final TryCount tryCount, final GameRule gameRule) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            progressRacing(gameRule);
            RacingCarView.printProgressResult(Cars.getCars());
        }
    }

    private static void progressRacing(final GameRule gameRule) {
        for (Car car : Cars.getCars()) {
            moveMovableCar(car, gameRule);
        }
    }

    private static void moveMovableCar(final Car car, final GameRule gameRule) {
        CarController carController = new CarController(car);
        RandomNumber randomNumber = new RandomNumber();
        if (gameRule.isMoveNumber(randomNumber.getNumber())) {
            carController.moveCar();
        }
    }

    private static void selectWinners() {
        Winners.allocateWinners(Cars.getCars());
    }
}
