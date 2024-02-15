package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.model.ConsoleReader;

public class MainController {
    public void run() {
        final Cars cars = getCars();
        final int tryCount = getTryCount();
        proceedRounds(cars, tryCount);
        printResult(cars);
    }

    private Cars getCars() {
        try {
            final List<String> carNames = InputView.readCarNames(new ConsoleReader());
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private int getTryCount() {
        try {
            return InputView.readTryCount(new ConsoleReader());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTryCount();
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
