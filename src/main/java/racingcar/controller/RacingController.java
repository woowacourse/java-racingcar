package racingcar.controller;

import java.io.IOException;

import racingcar.model.car.Cars;
import racingcar.model.value.TryCount;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 10;

    public void playGame() {
        Cars cars = inputCars();
        TryCount tryCount = inputTryCount();

        race(cars, tryCount);
        terminateGame(cars);
    }

    private Cars inputCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            return inputCars();
        }
    }

    private TryCount inputTryCount() {
        try {
            return new TryCount(InputView.inputTryCount());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            return inputTryCount();
        }
    }

    private void race(Cars cars, TryCount tryCount) {
        int currentTryCount = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(currentTryCount++)) {
            cars.moveAll(RandomNumberGenerator.fromBounds(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            OutputView.printCurrentCarInfo(cars.getCarsInfo());
        }
    }

    private void terminateGame(Cars cars) {
        OutputView.printCurrentCarInfo(cars.getCarsInfo());
        OutputView.printWinners(cars.getWinners());
    }
}

