package controller;

import service.CarService;
import service.wrapper.Round;
import utils.RacingNumberGenerator;
import view.InputView;
import view.OutputView;

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void run(RacingNumberGenerator generator) {
        try {
            carService.initCars(InputView.inputCarsName());
            Round round = generateRound();

            race(generator, round);
            OutputView.printWinner(carService.getWinner());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
            run(generator);
        }
    }

    private void race(RacingNumberGenerator generator, Round round) {
        OutputView.printRoundStartMessage();
        for (int count = 0; count < round.getRound(); count++) {
            carService.race(generator);
            OutputView.printRound(carService.getCarsDto());
        }
    }

    private Round generateRound() {
        try {
            return new Round(InputView.inputRound());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
            return generateRound();
        }
    }
}
