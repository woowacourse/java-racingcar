package racingcar;

import java.util.Scanner;

public class GameController {
    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startRace() {
        String carNames = InputView.getCarNames(scanner);
        Cars cars = new Cars(carNames.split(","));
        int moveCount = Integer.parseInt(InputView.getMoveCount(scanner));
        for (int i = 0; i < moveCount; i++) {
            cars.startEachRace();
            OutputView.printCarPosition(cars.getCarsToString());
        }
    }
}
