package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.view.RacingCarGameProgressView;
import racingcar.view.RacingCarGameResultView;

public class RacingCarGameController {
    RacingCarGame racingCarGame;
    RacingCarGameProgressView racingCarGameProgressView;
    RacingCarGameResultView racingCarGameResultView;

    public RacingCarGameController(final RacingCarGame racingCarGame, final RacingCarGameProgressView racingCarGameProgressView, final RacingCarGameResultView racingCarGameResultView) {
        this.racingCarGame = racingCarGame;
        this.racingCarGameProgressView = racingCarGameProgressView;
        this.racingCarGameResultView = racingCarGameResultView;
    }

    public boolean isRacing() {
        return racingCarGame.isRacing();
    }

    public void race() {
        racingCarGame.racing();
    }

    public void printRaceProgress() {
        racingCarGameProgressView.printProgressResult(racingCarGame.getCars());
    }

    public void printFinalResult() {
        racingCarGameResultView.printFinalResult(racingCarGame.getWinnersNames());
    }
}