package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Trial;
import racingcar.view.RacingGameView;

public class RacingGameController {

    final RacingGame racingGame;

    public RacingGameController() {
        String input = RacingGameView.requestCars();
        Cars cars = Cars.newInstance(input);

        input = RacingGameView.requestTrial();
        Trial trial = Trial.newInstance(input);

        racingGame = new RacingGame(cars, trial);
    }

    public void play() {
        race();
        finish();
    }

    private void race() {
        RacingGameView.printNewLine();
        RacingGameView.printResult();

        while (!racingGame.isFinished()) {
            racingGame.tryToMove();
            RacingGameView.printCarPositions(racingGame);
            RacingGameView.printNewLine();
        }
    }

    private void finish() {
        final List<String> winnerNames = racingGame.getWinners();
        RacingGameView.printWinners(winnerNames);
    }
}
