package racing.controller;

import racing.domain.RacingGame;
import racing.view.output.OutputView;

public class GameController {
    private final RacingGame racingGame;

    public GameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void run() {
        OutputView.printPhrase();
        int tryCount = racingGame.getTryCount();
        while (tryCount-- > 0) {
            racingGame.move();
            OutputView.printStep(racingGame.getCars());
        }
        OutputView.printFinalResult(racingGame.findWinners());
    }
}
