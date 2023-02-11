package controller;

import domain.Car;
import domain.Cars;
import dto.CarDto;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public void run() throws IOException {
        Cars cars = getCars();
        int attemptNumber = InputView.readAttemptNumber();
        printRacingResult(attemptNumber, cars);
        printWinners(cars);
    }

    private Cars getCars() throws IOException {
        List<String> carNames = InputView.readCarNames();
        try {
            List<Car> carList = getCarList(carNames);
            return new Cars(carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private List<Car> getCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void printRacingResult(int attemptNumber, Cars cars) {
        OutputView.printResult();
        while ((attemptNumber--) > 0) {
            cars.moveAll(numberGenerator);
            printStatus(cars);
        }
    }

    private void printStatus(Cars cars) {
        List<CarDto> carDtos = getCarDtos(cars);
        OutputView.printStatus(carDtos);
    }

    private List<CarDto> getCarDtos(Cars cars) {
        return cars.getCars().stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    private void printWinners(Cars cars) {
        Cars winnerCars = cars.findWinners();
        List<CarDto> winnerCarDtos = getCarDtos(winnerCars);
        OutputView.printWinners(winnerCarDtos);
    }
}
