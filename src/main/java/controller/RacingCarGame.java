package controller;

import domain.Cars;
import domain.Count;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class RacingCarGame {
    private final InputView inputView;

    public RacingCarGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = retry(() -> new Cars(inputView.enterCarNames()));
        Count count = retry(() -> new Count(inputView.enterCount()));

        OutputView.printNewLine();

        OutputView.printResultMessage();
        for (int i = 0; i < count.get(); i++) {
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
