package racingcar;

import racingcar.domian.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        String gameRound = InputView.inputGameRound();
        OutputView.printNotice();
        RacingGame racingGame = new RacingGame(carNames, gameRound);
        OutputView.printResult(racingGame.getResult());
    }
}
