package racinggame;

import java.io.IOException;
import java.util.function.Supplier;
import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.Round;
import racinggame.domain.condition.RandomMoveCondition;

public class Main {

    public static void main(String[] args) throws IOException {
        Cars cars = repeat(InputView::readCars);
        Round round = repeat(InputView::readRound);
        RacingGame game = RacingGame.of(cars, new RandomMoveCondition());

        OutputView.printResult(game.race(round));
        OutputView.printWinner(game.findWinnerName());
    }

    private static <T> T repeat(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
