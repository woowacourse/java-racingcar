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
        moveCar(carRepository);
    }

    private CarRepository makeCars() {
        CarFactory carFactory = new CarFactory();

        return carFactory.createCarRepository(inputView.readCars());
    }

    private void moveCar(CarRepository carRepository) {
        GameSystem gameSystem = new GameSystem(inputView.readGameRound(), new NumberGenerator());
        outputView.printResultGuide();

        Result result = gameSystem.executeRace(carRepository);
        outputView.printResult(result);
        outputView.printWinners(result);
    }


}
