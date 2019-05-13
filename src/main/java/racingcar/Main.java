package racingcar;

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
        OutputView.printResultStart();
        // 게임 실행
        Winner winner = racingGame.run();
        OutputView.printWinners(winner);
    }
}
