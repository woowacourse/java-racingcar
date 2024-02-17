package racinggame;

import java.io.IOException;
import racinggame.domain.RacingGame;
import racinggame.domain.condition.RandomMoveCondition;

public class Main {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame(inputView.readCars(), new RandomMoveCondition());

        game.race(inputView.readRound());

        outputView.printResult(game.getResult());
        outputView.printWinner(game.findWinnerName());
    }
}
