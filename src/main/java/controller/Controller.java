package controller;

import domain.NumberPicker;
import domain.RacingStatus;
import dto.RacingStatusDto;
import view.Input;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class Controller {
    private final NumberPicker numberPicker;
    private RacingStatus racingStatus;

    public Controller(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void raceTracks() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames, numberPicker);

        InputView.printInputTryCountGuide();

        int gameCount = Input.gameCountInput();
        OutputView.printStatusGuide();

        for (int i = 0; i < gameCount; i++) {
            racingStatus.move();
            OutputView.printStatus(racingStatus.toDto());
        }

        int max = findWinner(racingStatus.toDto());
        OutputView.printWinner(max, racingStatus.toDto());
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

    private int findWinner(List<RacingStatusDto> toDto) {
        int max = 0;
        //status, carName

        for (RacingStatusDto dto : toDto) {
            max = Math.max(dto.getStatus(), max);
        }

        return max;
    }
}
