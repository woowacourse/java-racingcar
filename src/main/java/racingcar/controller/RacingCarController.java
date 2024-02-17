package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.ConsoleReader;

public class RacingCarController {
    public void run() {
        final Cars cars = initCars();
        final int tryCount = initTryCount();
        proceedRounds(cars, tryCount);
        printResult(cars);
    }

    private Cars initCars() {
        try {
            final List<Car> cars = createCars(InputView.readCarNames(new ConsoleReader()));
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initCars();
        }
    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int initTryCount() {
        try {
            return InputView.readTryCount(new ConsoleReader());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initTryCount();
        }
    }

    private void proceedRounds(final Cars cars, final int tryCount) {
        OutputView.printResultSubject();
        IntStream.rangeClosed(1, tryCount)
                .forEach(i -> proceedOneRound(cars));
    }

    private void proceedOneRound(final Cars cars) {
        cars.move();
        OutputView.printResult(cars.result());
    }

    private void printResult(final Cars cars) {
        OutputView.printWinners(cars.getWinners());
    }
}
