package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private RacingGame racingGame;

    public void run() {
        initGame();
        runGame();
        endGame();
    }

    private void initGame() {
        List<Car> cars = InputView.inputCars();
        String inputTrialNum = InputView.inputTrialNum();
        racingGame = RacingGame.createRacingGame(cars, inputTrialNum);
    }

    private void runGame() {
        OutputView.printTrialResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCarPosition(racingGame);
        }
    }

    private void endGame() {
        OutputView.printWinnerName(racingGame.findWinner());
    }
}
