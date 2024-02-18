package controller;

import domain.Cars;
import domain.Count;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class RacingCarGame {
    public void run() {
        Cars cars = retry(() -> Cars.from(InputView.enterCarNames()));
        Count count = retry(() -> new Count(InputView.enterCount()));

        OutputView.printNewLine();

        OutputView.printResultMessage();
        for (int i = 0; i < count.getValue(); i++) {
            cars.move();
            OutputView.printResult(cars);
        }

        OutputView.printWinners(cars.judge());
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
