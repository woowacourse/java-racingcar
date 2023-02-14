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
        printWinner();
    }

    private void printWinner() {
        outputView.printWinner(racingStatus.findWinner());
    }

    private void getCarName(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            getCarName(runnable);
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

    private void raceTracks(int gameCount) {
        outputView.printStatusGuide();

        raceTrack(gameCount);
    }

    private void raceTrack(int gameCount) {
        //TODO: 반복문의 변수를 i,j,k...로 해도 괜찮은 걸까요? 의미있는 네이밍이 더 좋을 것 같은데 딱히 떠오르지가 않네요 ㅜ
        for (int i = 0; i < gameCount; i++) {
            racingStatus.moveCars();
            outputView.printStatus(racingStatus.toDto());
        }
    }
}
