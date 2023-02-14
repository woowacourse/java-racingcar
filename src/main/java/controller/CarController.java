package controller;

import exception.DuplicateCarNameException;
import model.Car;
import model.Cars;
import service.wrapper.Round;
import utils.RacingNumberGenerator;
import utils.StringUtils;
import view.InputView;
import view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarController {

    private Cars cars;

    public void run(RacingNumberGenerator generator) {
        try {
            cars = generateCars(InputView.inputCarsName());
            Round round = generateRound();

            race(generator, round);
            OutputView.printWinner(cars.getWinner());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
            run(generator);
        }
    }

    private void race(RacingNumberGenerator generator, Round round) {
        OutputView.printRoundStartMessage();
        for (int count = 0; count < round.getRound(); count++) {
            cars.race(generator);
            OutputView.printRound(cars.getCarsDto());
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

    public Cars generateCars(String inputCarsName) {
        String[] carsName = StringUtils.splitBySeparator(inputCarsName);
        checkDuplication(carsName);
        return new Cars(mapToCars(carsName));
    }

    private List<Car> mapToCars(String[] carsName) {
        return Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());
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
}
