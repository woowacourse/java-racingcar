package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Trial;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGameController() {
    }

    public static void play() {
        final RacingGame racingGame = prepare();
        race(racingGame);
        finish(racingGame);
    }

    private static RacingGame prepare() {
        String input = RacingGameView.requestCars();
        Cars cars = Cars.newInstance(input);

        input = RacingGameView.requestTrial();
        Trial trial = Trial.newInstance(input);

        return new RacingGame(cars, trial);
    }

    private static void race(final RacingGame racingGame) {
        RacingGameView.printNewLine();
        RacingGameView.printResult();

        while (!racingGame.isFinished()) {
            racingGame.tryToMove();
            RacingGameView.printCarPositions(racingGame);
            RacingGameView.printNewLine();
        }
    }

    private static void finish(final RacingGame racingGame) {
        final List<String> winnerNames = racingGame.getWinners();
        RacingGameView.printWinners(winnerNames);
    }
}
