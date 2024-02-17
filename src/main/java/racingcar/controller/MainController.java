package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.model.ConsoleReader;

public class MainController {
    public void run() {
        final Cars cars = createCars(InputView.readCarNames(new ConsoleReader()));
        final int tryCount = promptUserForTryCount();
        proceedRounds(cars, tryCount);
        printResult(cars);
    }

    private Cars createCars(final List<String> carNames) {
        try {
            final List<Car> cars = carNames.stream()
                    .map(Car::new)
                    .toList();
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createCars(carNames);
        }
    }

    private int promptUserForTryCount() {
        try {
            return InputView.readTryCount(new ConsoleReader());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return promptUserForTryCount();
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
