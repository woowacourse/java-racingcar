package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundResult;
import racingcar.domain.WinningCarsFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingGameController {
    private RacingGame racingGame;

    public void createCars() {
        racingGame = new RacingGame(InputView.inputCarList(), InputView.inputTryCount());
    }

    public void playRacingGame() {
        ArrayList<RoundResult> allResult = new ArrayList<>();

        while (!racingGame.isZeroTryCount()) {
            allResult.add(playOneRound());
        }
        OutputView.outputAllTryCarPosition(allResult);
        OutputView.outputWinners(WinningCarsFinder.findWinningCars(allResult.get(allResult.size() - 1).getRoundResult()));
    }

    private RoundResult playOneRound() {
        ArrayList<Car> oneRound = new ArrayList<>();

        oneRound = racingGame.race();
        racingGame.subtractTryCount();
        return new RoundResult(oneRound);
    }
}