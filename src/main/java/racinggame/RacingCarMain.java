package racinggame;

import java.util.List;
import java.util.function.Supplier;
import racinggame.domain.Cars;
import racinggame.domain.Name;
import racinggame.domain.RacingGame;
import racinggame.domain.Round;
import racinggame.domain.condition.RandomMoveCondition;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingCarMain {

    public static void main(String[] args) {
        List<Name> names = repeat(InputView::readNames);
        Round round = repeat(InputView::readRound);
        RacingGame game = new RacingGame(Cars.of(names), new RandomMoveCondition());

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
