package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.MoveCountValidator;
import racingcar.utils.StringSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class GameController {
    private static final int RANDOM_NUMBER_MIN_BOUND = 0;
    private static final int RANDOM_NUMBER_MAX_BOUND = 9;

    private final InputView inputView;

    public GameController(Scanner scanner) {
        this.inputView = new InputView(scanner);

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
            cars.startEachRace(RANDOM_NUMBER_MIN_BOUND, RANDOM_NUMBER_MAX_BOUND);
            OutputView.printCarsPosition(cars);
        }
    }
}
