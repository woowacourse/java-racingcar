package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private RacingGame racingGame;

    public RacingGameController() {
        String[] carNames = CarNameSpliter.splitCarNames(InputView.inputCarList());
        int tryCount = InputView.inputTryCount();

        racingGame = new RacingGame(carNames, tryCount);
    }

    public void playRacingGame() {
        List<RaceResult> allResult = racingGame.raceAll();
        RaceResult lastResult = allResult.get(allResult.size() - 1);

        OutputView.outputAllTryCarPosition(allResult);
        OutputView.outputWinners(lastResult.findWinningCars());
    }
}