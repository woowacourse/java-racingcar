package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.askCarName();
        int trialCount = InputView.askTryCount();

        RacingGame racingGame = new RacingGame(carNames, trialCount);
        OutputView.printGameStartMessage();
        while (!racingGame.isEnd()) {
            racingGame.doOneTrial();
            OutputView.printCurrentRaceState(racingGame.getGameState());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
