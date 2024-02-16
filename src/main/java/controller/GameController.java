package controller;

import domain.Cars;
import domain.Count;
import domain.RacingCarGame;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class GameController {
    public void run() {
        Cars cars = retry(() -> Cars.from(InputView.enterCarNames()));
        Count count = retry(() -> new Count(InputView.enterCount()));

        RacingCarGame racingCarGame = new RacingCarGame(cars, count);
        racingCarGame.race();

        // TODO : racingCarGame.getWinners() 가 아닌 cars.judge()를 해도 같지 않나? 고민해보기
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
