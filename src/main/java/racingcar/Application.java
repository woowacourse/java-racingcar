package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        String userInputCarNames = InputView.askCarName();
        String tryCount = InputView.askTryCount();

        racingGame.playGame(userInputCarNames, tryCount);

        String winnersName = racingGame.getWinnersName();
        OutputView.printWinners(winnersName);
    }
}
