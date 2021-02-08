package racingcar;

import java.util.Scanner;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRunner {

    final Scanner scanner;

    private Cars cars;
    private Rounds rounds;

    public GameRunner(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        Name[] names = InputView.getNames(scanner);
        this.cars = Cars.createByNames(names);

        this.rounds = InputView.getRounds(scanner);

        OutputView.println("실행 결과");
        while (!rounds.isEnd()) {
            this.cars.tryMoveCars();
            OutputView.printResult(this.cars.getAllCarsPosition());
            this.rounds.next();
        }

        OutputView.printWinner(this.cars.getWinners());
    }
}
