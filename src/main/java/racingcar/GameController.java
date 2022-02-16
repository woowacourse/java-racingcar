package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.CarNameValidator;
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
        Cars cars = getProperCars();
        int moveCount = Integer.parseInt(InputView.getMoveCount(scanner));
        OutputView.printResultMessage();
        startRace(cars, moveCount);
        OutputView.printWinners(cars.findWinners());
    }

    private Cars getProperCars() {
        try {
            String carNames = InputView.getCarNames(scanner);
            String[] splitCarNames = StringSeparator.splitAndTrim(carNames);
            CarNameValidator.validateCarNames(splitCarNames);
            return new Cars(splitCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProperCars();
        }
    }

    private void startRace(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.startEachRace();
            OutputView.printCarsPosition(cars);
        }
    }
}
