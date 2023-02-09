package controller;

import domain.CarRepository;
import service.CarFactory;
import service.GamePlay;
import view.InputView;
import view.OutputView;

public class InputController {

    GamePlay gamePlay = new GamePlay();
    CarRepository carRepository;

    public InputController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void startProgram() {

        OutputView.printInputCarNamesNotice();
        carRepository.insertCarBoard(CarFactory.buildCars(InputView.inputCarNames()));
        gamePlay.gameStart(carRepository);

    }

}
