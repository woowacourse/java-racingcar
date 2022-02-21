package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.MoveCountValidator;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StringSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = readyCars();
        int moveCount = getProperMoveCount();
        startRace(cars, moveCount);
        OutputView.printWinners(cars.findWinners());
    }

    private Cars readyCars() {
        try {
            String carNames = inputView.askCarNames();
            String[] splitCarNames = StringSeparator.splitAndTrim(carNames);
            return new Cars(splitCarNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return readyCars();
        }
    }

    private int getProperMoveCount() {
        try {
            String moveCount = inputView.askMoveCount();
            MoveCountValidator.validateMoveCount(moveCount);
            return Integer.parseInt(moveCount);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return getProperMoveCount();
        }
    }

    private void startRace(Cars cars, int moveCount) {
        OutputView.printResultMessage();
        for (int i = 0; i < moveCount; i++) {
            cars.startEachRace(numberGenerator);
            OutputView.printCarsPosition(cars);
        }
    }
}
