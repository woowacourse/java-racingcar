import domain.Cars;
import domain.Count;
import domain.RacingCarGame;
import domain.RandomPowerGenerator;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class CarRacingMain {
    public static void main(String[] args) {
        Cars cars = retry(() -> Cars.from(InputView.enterCarNames()));
        Count count = retry(() -> Count.from(InputView.enterCount()));

        RacingCarGame racingCarGame = new RacingCarGame(cars, count, new RandomPowerGenerator());

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
