package racingcar.controller;

import java.io.IOException;

import racingcar.model.Cars;
import racingcar.model.TryCount;
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
        int nowTryCnt = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(nowTryCnt++)) {
            cars.moveAll(RandomNumberGenerator.fromBounds(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            OutputView.printString(cars.toString());
        }
    }

    private void terminate() {
        OutputView.printString(cars.toString());
        OutputView.printString(cars.getWinners().toString());
    }
}

