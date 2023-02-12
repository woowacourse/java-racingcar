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

    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public CarController(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void run(RacingNumberGenerator generator) {
        carService.generateCars(generateCars());
        Round round = generateRound();

        race(generator, round);
        outputView.printWinner(carService.getWinner());
    }

    private void race(RacingNumberGenerator generator, Round round) {
        outputView.printRoundStartMessage();
        for (int count = 0; count < round.getRound(); count++) {
            carService.race(generator);
            outputView.printRound(carService.getCarsDto());
        }
    }

    private List<Car> generateCars() {
        try {
            String[] carsName = inputView.inputCarsName().split(SEPARATOR);
            checkDuplication(carsName);
            return mapToCars(carsName);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateCars();
        }
    }

    private static void checkDuplication(String[] carsName) {
        if (getDistinctCarsCount(carsName) != carsName.length) {
            throw new DuplicateCarNameException();
        }
    }

    private static long getDistinctCarsCount(String[] carsName) {
        return Arrays.stream(carsName)
                .distinct()
                .count();
    }

    private static List<Car> mapToCars(String[] carsName) {
        return Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());
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
