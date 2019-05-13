package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int numberOfTimes = InputView.inputNumberOfTimes();
        Racing racingGame = new Racing(carNames);
        OutputView.printResultStart();
        // 게임 실행
        for (int i = 0; i < numberOfTimes; ++i) {
            OutputView.printMoveResult(racingGame.run());
        }
        OutputView.printWinners(racingGame.getWinner());
    }
}
