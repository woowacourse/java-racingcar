package controller;

import domain.Cars;
import dto.CarDto;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class RacingCarController {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

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
        int attemptNumber = InputView.readAttemptNumber();
        OutputView.printResult();
        while ((attemptNumber--) > 0) {
            cars.moveAll(numberGenerator);
            printStatus(cars);
        }
    }

    private void printStatus(final Cars cars) {
        List<CarDto> carDtos = CarDto.getCarDtos(cars);
        OutputView.printStatus(carDtos);
    }

    private void printWinners(final Cars cars) {
        Cars winnerCars = cars.findWinners();
        List<CarDto> winnerCarDtos = CarDto.getCarDtos(winnerCars);
        OutputView.printWinners(winnerCarDtos);
    }
}
