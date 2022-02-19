package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        String carNames = InputView.inputCarNames();
        String trialNum = InputView.inputTrialNum();

        RacingGame racingGame = new RacingGame(carNames, trialNum);
        startRace(racingGame);
    }

    private void startRace(RacingGame racingGame) {
        OutputView.printTrialResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCarPosition(racingGame.getRacingCars());
        }
        OutputView.printWinnerName(racingGame.findWinner());
    }
}
