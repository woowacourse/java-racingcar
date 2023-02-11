package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.carrepository.CarRepository;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.result.Result;
import racingcar.domain.system.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarRepository carRepository = makeCars();
        GameSystem gameSystem = moveCar(carRepository);
        printResult(carRepository, gameSystem);
    }

    private CarRepository makeCars() {
        CarFactory carFactory = new CarFactory();
        while (true) {
            try {
                return carFactory.createCarRepository(inputView.readCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GameSystem moveCar(CarRepository carRepository) {
        while (true) {
            try {
                return new GameSystem(inputView.readGameRound(), new NumberGenerator());
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private void printResult(CarRepository carRepository, GameSystem gameSystem) {

        outputView.printResultGuide();

        Result result = gameSystem.startRace(carRepository);
        outputView.printResult(result);
        outputView.printWinners(result);
    }
}
