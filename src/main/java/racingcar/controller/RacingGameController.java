package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;
import racingcar.domain.Car;
import racingcar.utils.ParsingUtils;

public class RacingGameController {

    final RacingGame racingGame;

    public RacingGameController() {
        String input = RacingGameView.requestCars();
        List<Car> cars = ParsingUtils.parseCarNames(input);

        input = RacingGameView.requestTrial();
        int trial = ParsingUtils.parseTrial(input);

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
