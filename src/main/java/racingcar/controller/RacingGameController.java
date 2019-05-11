package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarNameSpliter;
import racingcar.domain.RacingGame;
import racingcar.domain.WinningCarsFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private RacingGame racingGame;

    public RacingGameController() {
        String[] carNames = CarNameSpliter.splitCarNames(InputView.inputCarList());
        int tryCount = InputView.inputTryCount();

        racingGame = new RacingGame(carNames, tryCount);
    }

    public void playRacingGame() {
        List<List<Car>> allResult = racingGame.raceAll();

        OutputView.outputAllTryCarPosition(allResult);
        OutputView.outputWinners(WinningCarsFinder.findWinningCars(allResult.get(allResult.size() - 1)));
    }
}