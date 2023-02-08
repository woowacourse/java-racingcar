package controller;

import domain.NumberPicker;
import domain.RacingStatus;
import view.Input;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final NumberPicker numberPicker;
    private RacingStatus racingStatus;

    public Controller(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void raceTracks() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames);

        InputView.printInputTryCountGuide();
        Input.gameCountInput();

        numberPicker.pickNumber();
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
