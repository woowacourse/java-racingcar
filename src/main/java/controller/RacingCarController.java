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
        race(cars);
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

    private void race(final Cars cars) throws IOException {
        try {
            AttemptNumber attemptNumber = new AttemptNumber(InputView.readAttemptNumber());
            OutputView.printResult();
            raceCars(cars, attemptNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            race(cars);
        }
    }

    private void raceCars(final Cars cars, final AttemptNumber attemptNumber) {
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
