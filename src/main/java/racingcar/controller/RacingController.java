package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void start() {
        try {
            Cars cars = new Cars(InputView.inputCarNames());
            TryCount tryCount = inputTryCount();
            race(cars, tryCount);
            printRaceResult(cars);

        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            start();
        }
    }

    private TryCount inputTryCount() {
        try {
            return new TryCount(InputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputTryCount();
        }
    }

    private void race(Cars cars, TryCount tryCount) {
        int nowTryCnt = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(nowTryCnt++)) {
            cars.moveAll();
            OutputView.printCarsStatus(cars.getCars());
        }
    }

    private void printRaceResult(Cars cars) {
        OutputView.printCarsStatus(cars.getCars());
        OutputView.printWinners(cars.getWinners());
    }
}

