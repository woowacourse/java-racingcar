package racinggame;

import java.util.function.Supplier;
import racinggame.domain.RacingGame;
import racinggame.domain.condition.RandomMoveCondition;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingGame game = RacingGame.of(repeat(InputView::readCars), new RandomMoveCondition());
        
        OutputView.printResult(game.race(repeat(InputView::readRound)));
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
