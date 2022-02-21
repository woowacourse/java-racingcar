package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberMoveStrategy;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(final RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void proceedRacingGame() {
        RandomNumberMoveStrategy randomNumberMoveStrategy = new RandomNumberMoveStrategy();

        OutputView.printRaceResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.run(randomNumberMoveStrategy);
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
