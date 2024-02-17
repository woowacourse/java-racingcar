package racinggame;

import java.io.IOException;
import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.Round;
import racinggame.domain.condition.RandomMoveCondition;

public class Main {

    public static void main(String[] args) throws IOException {
        Cars cars = InputView.readCars();
        Round round = InputView.readRound();
        RacingGame game = RacingGame.of(cars, new RandomMoveCondition());

        OutputView.printResult(game.race(round));
        OutputView.printWinner(game.findWinnerName());
    }
}
