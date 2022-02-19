package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(final RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void proceedRacingGame() {
        OutputView.printRaceResultMessage();

        while (!racingGame.isFinished()) {
            racingGame.run();
            updateViewOneTurnResult();
        }
    }

    public void updateViewOneTurnResult() {
        OutputView.printOneTurnRaceResult(racingGame.getCarList());
    }

    public void updateViewChampionNames() {
        OutputView.printChampionNames(racingGame.getChampionNames());
    }
}
