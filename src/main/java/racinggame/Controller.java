package racinggame;

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
    private final ObjectMapper objectMapper;

    public Controller(InputView inputView, OutputView outputView, ObjectMapper objectMapper) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.objectMapper = objectMapper;
    }

    public void run(MoveCondition moveCondition) {
        List<Car> cars = objectMapper.mapToCars(inputView.readCars());
        Round round = objectMapper.mapToRound(inputView.readRound());
        RacingGame game = new RacingGame(cars, moveCondition);

        play(game, round);
    }

    private void play(RacingGame game, Round round) {
        outputView.printResult(game.race(round));
        outputView.printWinner(game.award());
    }
}
