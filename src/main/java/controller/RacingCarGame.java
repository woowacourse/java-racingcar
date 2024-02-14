package controller;

import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarGame {
    private final InputView inputView;

    public RacingCarGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = retry(inputView::enterCarNames);
        int count = retry(inputView::enterCount);
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
