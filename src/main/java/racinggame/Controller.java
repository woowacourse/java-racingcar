package racinggame;

import java.io.IOException;
import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.MoveCondition;
import racinggame.domain.RacingGame;
import racinggame.domain.Round;
import racinggame.view.InputView;
import racinggame.view.OutputView;

class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(MoveCondition moveCondition) throws IOException {
        List<Car> cars = inputView.readCars();
        Round round = inputView.readRound();
        RacingGame game = new RacingGame(cars, moveCondition);

        game.race(round);

        outputView.printResult(game.getResult());
        outputView.printWinner(game.findWinnersName());
    }
}
