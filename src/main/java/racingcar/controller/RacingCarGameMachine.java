package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.ConsoleReader;

public class RacingCarGameMachine {
    private final ConsoleReader reader;

    public RacingCarGameMachine(ConsoleReader reader) {
        this.reader = reader;
    }

    public void run() {
        final Cars cars = initCars();
        final TryCount tryCount = initTryCount();
        proceedRounds(cars, tryCount);
        printResult(cars);
    }

    private Cars initCars() {
        try {
            final List<String> cars = InputView.readCarNames(reader);
            return Cars.of(cars);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initCars();
        }
    }

    private TryCount initTryCount() {
        try {
            final int tryCount = InputView.readTryCount(reader);
            return new TryCount(tryCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initTryCount();
        }
    }

    private void proceedRounds(final Cars cars, final TryCount tryCount) {
        OutputView.printResultSubject();
        tryCount.execute(() -> proceedOneRound(cars));
    }

    private void proceedOneRound(final Cars cars) {
        cars.move(new RandomNumberGenerator());
        OutputView.printResult(cars.result());
    }

    private void printResult(final Cars cars) {
        OutputView.printWinners(cars.getWinners());
    }
}
