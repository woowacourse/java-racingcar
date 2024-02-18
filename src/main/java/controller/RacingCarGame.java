package controller;

import view.OutputView;

import java.util.function.Supplier;

public class RacingCarGame {
    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void run() {
    }
}
