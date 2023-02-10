package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.CarContainer;
import racingcar.domain.NumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public static final String GAME_COUNT_ERROR_MESSAGE = "올바른 회수를 입력해주세요";

    private final NumberPicker numberPicker;
    private final OutputView outputView;
    private final InputView inputView;
    private CarContainer carContainer;

    public Controller(NumberPicker numberPicker, OutputView outputView, InputView inputView) {
        this.numberPicker = numberPicker;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void raceTracks() {
        setRacingCar();
        race();
        printResult();
    }

    private void setRacingCar() {
        String carNames = handleError(inputView::inputCarName);
        carContainer = new CarContainer(carNames, numberPicker);
    }

    private void race() {
        int gameCount = handleError(inputView::inputTryCount);
        outputView.printStatusGuide();
        for (int currentRound = 0; currentRound < gameCount; currentRound++) {
            carContainer.moveCars();
            outputView.printStatus(carContainer.toDto());
        }
    }

    private void printResult() {
        outputView.printWinner(carContainer.findWinner());
    }

    private <T> T handleError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(GAME_COUNT_ERROR_MESSAGE);
            return handleError(supplier);
        }
    }
}
