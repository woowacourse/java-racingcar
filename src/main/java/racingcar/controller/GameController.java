package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    public void run() {
        InputView.inputCarNames();
        String carNames = InputView.getInput();
        InputView.inputTrialNum();
        String trialNum = InputView.getInput();

        RacingGame racingGame = new RacingGame(carNames, trialNum);
        startRace(racingGame);
    }

    private void startRace(RacingGame racingGame) {
        OutputView.printTrialResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCarPosition(racingGame.getCars());
        }
        OutputView.printWinnerName(findWinner(racingGame.getCars()));
    }

    public String findWinner(Cars cars) {
        int maxPosition = cars.findMaxPosition();
        return cars.findWinnerName(maxPosition);
    }
}
