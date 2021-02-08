package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;
import racingcar.domain.Car;
import racingcar.utils.ParsingUtils;

public class RacingGameController {

    RacingGame racingGame;

    public void play() {
        prepare();
        race();
        finish();
    }

    private void prepare() {
        String input = RacingGameView.requestCars();
        List<Car> cars = ParsingUtils.parseCarNames(input);

        input = RacingGameView.requestTrial();
        int trial = ParsingUtils.parseTrial(input);

        racingGame = new RacingGame(cars, trial);
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
        List<String> winnerNames = racingGame.getWinners();
        RacingGameView.printWinners(winnerNames);
    }
}
