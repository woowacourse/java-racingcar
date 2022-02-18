package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.MoveCountValidator;
import racingcar.utils.StringSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class GameController {
    private final Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        Cars cars = readyCars();
        int moveCount = getProperMoveCount();
        startRace(cars, moveCount);
        OutputView.printWinners(cars.findWinners());
    }

    private Cars readyCars() {
        try {
            String carNames = InputView.getCarNames(scanner);
            String[] splitCarNames = StringSeparator.splitAndTrim(carNames);
            return new Cars(splitCarNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return readyCars();
        }
    }

    private int getProperMoveCount() {
        try {
            String moveCount = InputView.getMoveCount(scanner);
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
            cars.startEachRace();
            OutputView.printCarsPosition(cars);
        }
    }
}
