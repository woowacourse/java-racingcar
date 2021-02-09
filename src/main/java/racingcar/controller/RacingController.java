package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.car.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingController {

    private final Scanner scanner;
    private final CarRegister carRegister;
    private final RacingTimeRegister racingTimeRegister;

    public RacingController(Scanner scanner) {
        this.scanner = scanner;
        this.carRegister = new CarRegister();
        this.racingTimeRegister = new RacingTimeRegister();
    }

    public void start() {
        CarRacingGameEngine carRacingGameEngine = new CarRacingGameEngine(createCar());
        int raceTime = applyRaceTime();

        showRaceResult();

        for (int i = 0; i < raceTime; i++) {
            carRacingGameEngine.race();
            showRaceState();
        }

        showRaceWinner();
    }

    private List<Car> createCar() {
        String carNames = InputView.inputCarName(scanner);

        return carRegister.registerCars(carNames);
    }

    private int applyRaceTime() {
        String inputTryTime = InputView.inputRaceTime(scanner);

        return racingTimeRegister.registerRacingTime(inputTryTime);
    }

    private void showRaceResult() {
        OutputView.printRaceResult();
    }

    private void showRaceState() {
        showAllCarsPosition();
        OutputView.printNewLine();
    }

    private void showAllCarsPosition() {
        CarRepository.cars().forEach(car ->
                OutputView.printRaceResultEachCar(
                        car.getName(), car.getPosition()));
    }

    private void showRaceWinner() {
        OutputView.printWinner(CarRepository.winnerNames());
    }
}
