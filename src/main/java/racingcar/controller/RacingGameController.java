package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private RacingGame racingGame = new RacingGame();

    public void createCars() {
        racingGame.generateCarList(racingGame.makeValidCarNames(InputView.inputCarList()));
    }

    public void configureTryCount() {
        racingGame.makeValidTryCount(InputView.inputTryCount());
    }

    public void raceAll() {
        OutputView.outputAllTryCarPosition(racingGame.raceAll());
    }

    public void findWinningCars() {
        OutputView.outputWinners(racingGame.findWinningCars());
    }
}