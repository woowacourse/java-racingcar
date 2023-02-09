package racingcar.controller;

import racingcar.domain.NumberPicker;
import racingcar.domain.RacingStatus;
import racingcar.view.Input;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final NumberPicker numberPicker;
    private final Input input;
    private final OutputView outputView;
    private final InputView inputView;
    private RacingStatus racingStatus;

    public Controller(NumberPicker numberPicker, Input input, OutputView outputView, InputView inputView) {
        this.numberPicker = numberPicker;
        this.input = input;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void raceTracks() {
        handleError(this::carNameInput);

        inputView.printInputTryCountGuide();
        int gameCount = handleError(input::gameCountInput);

        outputView.printStatusGuide();
        for (int i = 0; i < gameCount; i++) {
            racingStatus.move();
            outputView.printStatus(racingStatus.toDto());
        }

        outputView.printWinner(racingStatus.findWinner());
    }

    private void carNameInput() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames, numberPicker);
    }

    private String inputCarNames() {
        inputView.printInputCarNameGuide();
        return input.carNameInput();
    }

    private <T> T handleError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return handleError(supplier);
        }
    }

    private void handleError(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            handleError(runnable);
        }
    }
}
