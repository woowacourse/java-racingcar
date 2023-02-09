package controller;

import service.CarService;
import service.wrapper.Round;
import utils.RacingNumberGenerator;
import view.InputView;
import view.OutputView;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public CarController(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void run(RacingNumberGenerator generator) {
        generateCars();
        Round round = new Round(inputView.inputRound());

        outputView.printRoundStartMessage();
        for (int count = 0; count < round.getRound(); count++) {
            carService.race(generator);
            outputView.printRound(carService.getCarsDto());
        }
        outputView.printWinner(carService.getWinner());
    }

    private void generateCars() {
        try {
            String carNames = inputView.inputCarsName();
            carService.generateCars(carNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            generateCars();
        }
    }
}
