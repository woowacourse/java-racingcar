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
        handleError(this::carNameInput);

        InputView.printInputTryCountGuide();
        int gameCount = handleError(Input::gameCountInput);

        OutputView.printStatusGuide();
        for (int i = 0; i < gameCount; i++) {
            racingStatus.move();
            OutputView.printStatus(racingStatus.toDto());
        }

        OutputView.printWinner(racingStatus.findWinner());
    }

    private void carNameInput() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames, numberPicker);
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

    private void handleError(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            handleError(runnable);
        }
    }
}
