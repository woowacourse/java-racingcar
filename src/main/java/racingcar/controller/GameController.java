package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

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
        racingGame = new RacingGame(carNames, inputTrialNum);
    }


    private void runGame() {
        OutputView.printTrialResult();
        for (int i = 0; i < racingGame.getTrialNum().getTrialNum(); i++) {
            racingGame.race();
            OutputView.printCarPosition(racingGame.getCars());
        }
    }

    private void endGame() {
        OutputView.printWinnerName(racingGame.findWinner());
    }
}
