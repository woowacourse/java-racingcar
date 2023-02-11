package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.cars.Cars;
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
        Cars cars = makeCars(inputView.readCarNames());

        GameSystem gameSystem = createGameSystem(inputView.readGameRound());
        Result result = gameSystem.executeRace(cars);

        printResultAndWinner(result);
    }

    private Cars makeCars(List<String> carNames) {
        CarFactory carFactory = new CarFactory();
        return carFactory.createCarRepository(carNames);
    }

    private GameSystem createGameSystem(int gameRound) {
        return new GameSystem(gameRound, new NumberGenerator());
    }

    private void printResultAndWinner(Result result) {
        outputView.printResult(result);
        outputView.printWinner(result);
    }
}
