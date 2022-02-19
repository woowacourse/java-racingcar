package racingcar.controller;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.CarNameAndPosition;
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
            return TryCount.fromString(InputView.inputTryCount());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            return inputTryCount();
        }
    }

    private void race(Cars cars, TryCount tryCount) {
        TryCount currentTryCount = TryCount.initialize();
        OutputView.printStartMessage();
        while (isGameContinuable(tryCount, currentTryCount)) {
            cars.moveAll(RandomNumberGenerator.fromBounds(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            OutputView.printCurrentCarNameAndPosition(getCarsNameAndPosition(cars));
            currentTryCount = currentTryCount.increase();
        }
    }

    private void terminateGame(Cars cars) {
        OutputView.printCurrentCarNameAndPosition(getCarsNameAndPosition(cars));
        OutputView.printWinners(cars.getWinners());
    }

    private boolean isGameContinuable(TryCount totalTryCount, TryCount currentTryCount) {
        return !totalTryCount.equals(currentTryCount);
    }

    private List<CarNameAndPosition> getCarsNameAndPosition(Cars cars) {
        return cars.getCars().stream()
                .map(CarNameAndPosition::new)
                .collect(Collectors.toList());
    }
}

