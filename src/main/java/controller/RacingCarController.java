package controller;

import domain.AttemptNumber;
import domain.Cars;
import dto.CarDto;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class RacingCarController {

    private final NumberGenerator numberGenerator;

    public RacingCarController() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() throws IOException {
        Cars cars = getCars();
        AttemptNumber attemptNumber = getAttemptNumber();
        race(cars, attemptNumber);
        printWinners(cars);
    }

    private Cars getCars() throws IOException {
        List<String> carNames = InputView.readCarNames();
        try {
            return Cars.from(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private AttemptNumber getAttemptNumber() throws IOException {
        try {
            int number = InputView.readAttemptNumber();
            return new AttemptNumber(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAttemptNumber();
        }
    }

    private void race(final Cars cars, final AttemptNumber attemptNumber) throws IOException {
        while (attemptNumber.isRemain()) {
            attemptNumber.decrease();
            cars.moveAll(numberGenerator);
            printStatus(cars);
        }
    }

    private void printStatus(final Cars cars) {
        List<CarDto> carDtos = CarDto.getInstances(cars);
        OutputView.printStatus(carDtos);
    }

    private void printWinners(final Cars cars) {
        Cars winnerCars = cars.findWinners();
        List<CarDto> winnerCarDtos = CarDto.getInstances(winnerCars);
        OutputView.printWinners(winnerCarDtos);
    }
}
