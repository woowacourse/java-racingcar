package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class GameController {
    Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startRace() {
        String carNames = InputView.getCarNames(scanner);
        Cars cars = new Cars(Utils.splitAndTrim(carNames));
        int moveCount = Integer.parseInt(InputView.getMoveCount(scanner));
        OutputView.printResultMessage();
        for (int i = 0; i < moveCount; i++) {
            cars.startEachRace();
            OutputView.printCarPosition(cars.getCarsToString());
        }
        List<String> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }
}
