package controller;

import view.OutputView;

import java.util.function.Supplier;

public class Controller {

    private <T> T handleError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return handleError(supplier);
        }
    }
}
