package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.WinningCarsFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingGameController {
    private RacingGame racingGame = new RacingGame();

    public void createCars() {
        racingGame.generateCarList(InputView.inputCarList());
    }

    public void configureTryCount() {
        racingGame.configureTryCount(InputView.inputTryCount());
    }

    public void playRacingGame() {
        ArrayList<ArrayList<Car>> allResult = racingGame.raceAll();

        OutputView.outputAllTryCarPosition(allResult);
        OutputView.outputWinners(WinningCarsFinder.findWinningCars(allResult.get(allResult.size() - 1)));
    }
}