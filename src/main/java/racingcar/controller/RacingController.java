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

    private Cars cars;
    private TryCount tryCount;

    public void start() {
        try {
            cars = new Cars(InputView.inputCarNames());
            inputTryCount();
            race();
            terminate();
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            start();
        }
    }

    private void inputTryCount() {
        try {
            tryCount = new TryCount(InputView.inputTryCount());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            inputTryCount();
        }
    }

    private void race() {
        int currentTryCount = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(currentTryCount++)) {
            cars.moveAll(RandomNumberGenerator.fromBounds(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            OutputView.printStatus(cars.getCarsStatus());
        }
    }

    private void terminate() {
        OutputView.printStatus(cars.getCarsStatus());
        OutputView.printWinners(cars.getWinners());
    }
}

