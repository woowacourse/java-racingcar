package racingcar;

import java.util.Scanner;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRunner {

    private final Scanner scanner;

    private Cars cars;
    private Round round;

    public GameRunner(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        cars = Cars.createByNames(InputView.inputToNames(scanner));
        round = Round.create(InputView.inputToInteger(scanner));

        OutputView.printResultHeader();
        while (!round.isEnd()) {
            cars.tryMoveCars();
            cars.printAllCarsPosition();
            round.next();
        }
        OutputView.printWinner(cars.getWinners());
    }
}
