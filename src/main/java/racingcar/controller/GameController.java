package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.cars.Cars;
import racingcar.domain.numbergenerator.RandomSingleDigitGenerator;
import racingcar.domain.record.GameRecordManager;
import racingcar.domain.record.GameRecorder;
import racingcar.domain.system.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashSet;
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
        gameSystem.executeRace(cars, new RandomSingleDigitGenerator());

        outputView.printAllGameResults(gameSystem.getAllGameResult());
        outputView.printWinners(gameSystem.getWinnersGameResult());
    }

    private Cars makeCars(List<String> carNames) {
        CarFactory carFactory = new CarFactory();
        return carFactory.createCars(carNames);
    }

    private GameSystem createGameSystem(int gameRound) {
        return new GameSystem(gameRound, new GameRecorder(new LinkedHashSet<>(), new GameRecordManager()));
    }
}
