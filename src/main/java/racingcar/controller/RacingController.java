package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void start(MoveStrategy moveStrategy) {
        Cars cars = inputCars();
        TryCount tryCount = inputTryCount();
        race(cars, tryCount, moveStrategy);
        printRaceResult(cars);
    }

    private Cars inputCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputCars();
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

    private void race(Cars cars, TryCount tryCount, MoveStrategy moveStrategy) {
        int nowTryCnt = 0;
        OutputView.printStartMessage();
        while (tryCount.isNotSame(nowTryCnt++)) {
            cars.moveAll(moveStrategy);
            OutputView.printCarsStatus(cars.getCars());
        }
    }

    private void printRaceResult(Cars cars) {
        OutputView.printCarsStatus(cars.getCars());
        OutputView.printWinners(cars.getWinners());
    }
}

