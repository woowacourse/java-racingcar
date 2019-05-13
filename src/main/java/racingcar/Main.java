package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int numberOfTimes = InputView.inputNumberOfTimes();
        Racing racingGame = new Racing(carNames, numberOfTimes);
        Winner winner = racingGame.run();

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTimes; ++i) {
            racingGame.getCars().forEach(car -> OutputView.printCarDistance(car));
            System.out.println();
        }
        OutputView.printWinners(winner);
    }
}
