package controller;

import domain.Cars;
import domain.Count;
import domain.RacingCarGame;
import dto.RaceResult;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class GameController {
    public void run() {
        Cars cars = retry(() -> Cars.from(InputView.enterCarNames()));
        Count count = retry(() -> new Count(InputView.enterCount()));

        RacingCarGame racingCarGame = new RacingCarGame(cars, count);
        RaceResult raceResult = racingCarGame.race();

        OutputView.printRaceResult(raceResult);
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
