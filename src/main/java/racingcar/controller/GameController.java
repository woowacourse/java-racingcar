package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private RacingGame racingGame;

    public void run() {
        initGame();
        runGame();
        endGame();
    }

    private void initGame() {
        String carNames = InputView.inputCarNames();
        String inputTrialNum = InputView.inputTrialNum();
        racingGame = RacingGame.createRacingGame(carNames, inputTrialNum);
    }


    private void runGame() {
        OutputView.printTrialResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCarPosition(racingGame.getCars());
        }
    }

    private void endGame() {
        OutputView.printWinnerName(racingGame.findWinner());
    }
}
