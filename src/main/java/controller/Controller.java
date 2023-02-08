package controller;

import domain.RacingStatus;
import view.Input;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private RacingStatus racingStatus;

    public Controller() {
    }

    public void raceTracks() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames);
    }

    private String inputCarNames() {
        InputView.printInputCarNameGuide();
        return Input.carNameInput();
    }

    private <T> T handleError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return handleError(supplier);
        }
    }
}
