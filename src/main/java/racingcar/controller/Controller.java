package racingcar.controller;

import java.util.List;
import racingcar.domain.game.RacingGame;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.View;

public class Controller {

    private final View view;
    private final RacingGame racingGame;

    public Controller(List<String> names, int tryCount, RandomNumberGenerator randomNumberGenerator) {
        this.view = new View();
        this.racingGame = new RacingGame(names, tryCount, randomNumberGenerator);
    }

    public void runGame() {
        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResults(racingGame.getGameLog(), racingGame.getTryCount().getCurrentTryCount());
        }
        view.printWinnersResult(racingGame.getGameLog(), racingGame.getTryCount().getTotalTryCount());
    }
}
