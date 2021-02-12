package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {

    RacingCarGame racingCarGame;
    RacingCarGameView racingCarGameView;

    public RacingCarGameController(final RacingCarGame racingCarGame, final RacingCarGameView racingCarGameView) {
        this.racingCarGame = racingCarGame;
        this.racingCarGameView = racingCarGameView;
    }

    public void run() {
        racingCarGameRacing();
        printFinalResult();
    }

    private void racingCarGameRacing() {
        while (racingCarGame.isRacing()) {
            racingCarGame.racing();
            racingCarGameView.printProgressResult(racingCarGame.getCars());
        }
    }

    private void printFinalResult() {
        racingCarGameView.printFinalResult(racingCarGame.getWinnersNames());
    }
}
