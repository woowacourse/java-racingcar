package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private RacingGame racingGame = new RacingGame();

    public void createCars() {
        racingGame.generateCarList(InputView.inputCarList());
    }

    public void configureTryCount() {
        racingGame.configureTryCount(InputView.inputTryCount());
    }

    public void raceAll() {
        OutputView.outputAllTryCarPosition(racingGame.raceAll());
    }

    public void findWinningCars() {
        OutputView.outputWinners(racingGame.findWinningCars());
    }
}