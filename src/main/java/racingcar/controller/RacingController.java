package racingcar.controller;

import racingcar.domain.*;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingController {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final Scanner scanner;
    private final CarRegister carRegister;
    private final RacingTimeRegister racingTimeRegister;

    public RacingController(Scanner scanner) {
        this.scanner = scanner;
        this.carRegister = new CarRegister();
        this.racingTimeRegister = new RacingTimeRegister();
    }

    public void start() {
        createCar();
        race(applyRaceTime());
    }

    private void createCar() {
        String carNames = InputView.inputCarName(scanner);
        List<Car> cars = carRegister.registerCars(carNames);

        CarRepository.saveAll(cars);
    }

    private int applyRaceTime() {
        String inputTryTime = InputView.inputRaceTime(scanner);

        return racingTimeRegister.registerRacingTime(inputTryTime);
    }

    public void race(int tryTime) {
        List<Car> cars = CarRepository.cars();

        OutputView.printRaceResult();

        for (int i = 0; i < tryTime; i++) {
            updateAllCarsPosition(cars);
            showAllCarsPosition(cars);
            OutputView.printNewLine();
        }

        OutputView.printWinner(CarRepository.winnerNames());
    }

    private void updateAllCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            car.goForward(goForwardOrStopRandomly());
        }
    }

    private boolean goForwardOrStopRandomly() {
        int randomNumber = RandomGenerator
                .generateRandomNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        return GoForwardOrStop.isGoForward(randomNumber);
    }

    private void showAllCarsPosition(List<Car> cars) {
        cars.forEach(car ->
                OutputView.printRaceResultEachCar(
                        car.getName(), car.getPosition()));
    }
}
