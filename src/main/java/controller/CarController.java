package controller;

import dto.RacingRoundStateDto;
import java.util.List;
import java.util.Set;
import service.CarService;
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
        initCars();
        initRacingRound();
        race(generator);
        outputView.printWinner(carService.getWinner());
    }

    private void race(RacingNumberGenerator generator) {
        outputView.printRoundStartMessage();

        List<RacingRoundStateDto> racingTotalState = carService.race(generator);
        outputView.printRacingTotalState(racingTotalState);
    }

    private void initCars() {
        try {
            Set<String> carsName = inputView.inputCarsName();
            carService.initCars(carsName);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            initCars();
        }
    }

    private void initRacingRound() {
        try {
            int round = inputView.inputRound();
            carService.initRound(round);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            initRacingRound();
        }
    }
}
