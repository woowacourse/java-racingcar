package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Racing racingGame = new Racing(InputView.inputCarNames(), InputView.inputNumberOfTimes());
        Winner winner = racingGame.run();
        OutputView.printWinners(winner);
    }
}
