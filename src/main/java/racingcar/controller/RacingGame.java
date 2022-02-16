package racingcar.controller;

import racingcar.view.OutputView;

import java.util.Arrays;

public class RacingGame {
    private final RaceController raceController;
    private final int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        raceController = new RaceController();
        raceController.insertCarFromCarNames(carNames);
    }

    public void play() throws RuntimeException {
        OutputView.printResultPrefix();
        for (int i = 0; i < tryCount; i++) {
            raceController.moveRound();
            raceController.printPosition();
        }
        raceController.printWinner();
    }
}
