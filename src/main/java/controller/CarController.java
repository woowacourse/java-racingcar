package controller;

import java.util.Set;
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
        Round round = generateRound();

        race(generator, round);
        outputView.printWinner(carService.getWinner());
    }

    private void race(RacingNumberGenerator generator, Round round) {
        outputView.printRoundStartMessage();

        while (round.isRacing()) {
            carService.race(generator);
            outputView.printRoundState(carService.getRacingCarStateDto());
        }
    }

    private void generateCars() {
        try {
            Set<String> carsName = inputView.inputCarsName();
            carService.initCars(carsName);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            generateCars();
        }
    }

    private Round generateRound() {
        try {
            return new Round(inputView.inputRound());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateRound();
        }
    }
}
