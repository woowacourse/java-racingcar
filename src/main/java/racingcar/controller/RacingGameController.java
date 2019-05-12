package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundResult;
import racingcar.domain.WinningCarsFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private RacingGame racingGame;
    private WinningCarsFinder winningCarsFinder;

    public void createCars() {
        racingGame = new RacingGame(InputView.inputCarList(), InputView.inputTryCount());
    }

    public void playRacingGame() {
        List<RoundResult> allResult = new ArrayList<>();

        while (!racingGame.isZeroTryCount()) {
            allResult.add(playOneRound());
        }
        OutputView.outputAllTryCarPosition(allResult);
        winningCarsFinder = new WinningCarsFinder(allResult.get(allResult.size() - 1).getRoundResult());
        OutputView.outputWinners(winningCarsFinder.getWinningCars());
    }

    private RoundResult playOneRound() {
        List<Car> oneRound = new ArrayList<>();

        oneRound = racingGame.race();
        racingGame.subtractTryCount();
        return new RoundResult(oneRound);
    }
}
