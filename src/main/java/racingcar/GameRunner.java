package racingcar;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRunner {

    private final Scanner scanner;

    private Cars cars;
    private Rounds rounds;

    public GameRunner(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        List<Name> names = InputView.receiveNames(scanner);
        this.cars = Cars.createByNames(names);

        this.rounds = InputView.receiveRounds(scanner);

        OutputView.println("실행 결과");
        while (!rounds.isEnd()) {
            this.cars.tryMoveCars();

            List raceResults = cars.getAllResults();
            OutputView.printResults(raceResults);
            this.rounds.next();
        }

        OutputView.printWinner(this.cars.getWinners());
    }
}
