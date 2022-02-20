package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class RaceController {

    public void race(final RacingGame racingGame) {
        OutputView.printResultPrefix();
        while (!racingGame.isEnd()) {
            racingGame.raceRound();
            OutputView.printPosition(racingGame.getCars());
        }
        OutputView.printWinner(racingGame.getCars());
    }
}
