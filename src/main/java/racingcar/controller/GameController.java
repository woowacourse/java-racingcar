package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.cars.Cars;
import racingcar.domain.record.GameRecord;
import racingcar.domain.system.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
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
        gameSystem.executeRace(cars);

        outputView.printResult(gameSystem.getGameResult());
        outputView.printWinner(gameSystem.findWinners());
    }

    private Cars makeCars(List<String> carNames) {
        CarFactory carFactory = new CarFactory();
        return carFactory.createCars(carNames);
    }

    private GameSystem createGameSystem(int gameRound) {
        return new GameSystem(gameRound, new GameRecord(new LinkedHashMap<>()));
    }
}
