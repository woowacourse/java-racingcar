package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.carrepository.CarRepository;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.result.Result;
import racingcar.domain.system.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarRepository carRepository = makeCars(inputView.readCarNames());

        GameSystem gameSystem = createGameSystem(inputView.readGameRound());
        Result result = gameSystem.executeRace(carRepository);

        printResultAndWinner(result);
    }

    private GameSystem createGameSystem(int gameRound) {
        return new GameSystem(gameRound, new NumberGenerator());
    }

    private CarRepository makeCars(List<String> carNames) {
        CarFactory carFactory = new CarFactory();
        return carFactory.createCarRepository(carNames);
    }

    private void printResultAndWinner(Result result) {
        outputView.printResult(result);
        outputView.printWinner(result);
    }
}
