package racingcar;

import racingcar.domain.Lap;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNamesInput();
        Lap lap = new Lap(InputView.getLapInput());

        RacingCarGame racingCarGame = new RacingCarGame(carNames, lap);
        while (!racingCarGame.isEnd()) {
            OutputView.showResultMessage();
            racingCarGame.race();
            OutputView.showOneLapResult(racingCarGame.getResult());
        }
        OutputView.showWinners(racingCarGame.getWinners());
    }
}
