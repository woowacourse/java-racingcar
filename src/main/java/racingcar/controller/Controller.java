package racingcar.controller;

import racingcar.domain.NumberPicker;
import racingcar.domain.RacingStatus;
import racingcar.view.Input;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

public class Controller {
    public static final String GAME_COUNT_ERROR_MESSAGE = "[ERROR] 정수값을 입력해주세요";
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

    public void game() {
        getCarName(this::carNameInput);
        
        int gameCount = getGameCount(input::gameCountInput);
        raceTracks(gameCount);
        outputView.printWinner(racingStatus.findWinner());
    }

    private void raceTracks(int gameCount) {
        outputView.printStatusGuide();

        raceTrack(gameCount);
    }

    private void raceTrack(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            racingStatus.moveCars();
            outputView.printStatus(racingStatus.toDto());
        }
    }

    private void carNameInput() {
        String carNames = inputCarNames();
        racingStatus = new RacingStatus(carNames, numberPicker);
    }

    private String inputCarNames() {
        inputView.printInputCarNameGuide();
        return input.carNameInput();
    }

    private <T> T getGameCount(Supplier<T> supplier) {
        inputView.printInputTryCountGuide();
        
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(GAME_COUNT_ERROR_MESSAGE);
            return getGameCount(supplier);
        }
    }

    private void getCarName(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            getGameCount(runnable);
        }
    }
}
