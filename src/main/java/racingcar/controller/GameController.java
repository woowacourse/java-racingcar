package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.carrepository.CarRepository;
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

        int gameRound = inputView.readGameRound();

        outputView.printResultGuide();
        for (int i = 0; i < gameRound; i++) {
            carRepository.movePosition();
            outputView.printResult(carRepository);
        }
        outputView.printWinners(carRepository);
    }


}
