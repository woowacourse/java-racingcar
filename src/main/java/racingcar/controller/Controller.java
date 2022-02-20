package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.View;

public class Controller {

    private final View view;
    private final Game game;

    public Controller(List<String> names, int tryCount, RandomNumberGenerator randomNumberGenerator) {
        this.view = View.getInstance();
        this.game = new Game(names, tryCount, randomNumberGenerator);
    }

    public void runGame() {
        view.printResultViewTitle();
        while (!game.isFinished()) {
            game.proceedTurn();
            game.getGameLog().printMidtermResults(game.getTryCount().getCurrentTryCount());
        }
        game.getGameLog().printWinnersResult(game.getTryCount().getTotalTryCount());
    }
}
