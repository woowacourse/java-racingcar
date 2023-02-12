package controller;

import exception.DuplicateCarNameException;
import model.Car;
import service.CarService;
import service.wrapper.Round;
import utils.RacingNumberGenerator;
import view.InputView;
import view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarController {

    private static final String SEPARATOR = ",";
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void run(RacingNumberGenerator generator) {
        carService.generateCars(generateCars());
        Round round = generateRound();

        race(generator, round);
        OutputView.printWinner(carService.getWinner());
    }

    private void race(RacingNumberGenerator generator, Round round) {
        OutputView.printRoundStartMessage();
        for (int count = 0; count < round.getRound(); count++) {
            carService.race(generator);
            OutputView.printRound(carService.getCarsDto());
        }
    }

    private List<Car> generateCars() {
        try {
            String[] carsName = InputView.inputCarsName().split(SEPARATOR);
            checkDuplication(carsName);
            return mapToCars(carsName);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
            return generateCars();
        }
    }

    private void checkDuplication(String[] carsName) {
        if (getDistinctCarsCount(carsName) != carsName.length) {
            throw new DuplicateCarNameException();
        }
    }

    private long getDistinctCarsCount(String[] carsName) {
        return Arrays.stream(carsName)
                .distinct()
                .count();
    }

    private List<Car> mapToCars(String[] carsName) {
        return Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());
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
