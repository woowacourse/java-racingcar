package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;

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
        new CarRacingGameEngine(createCar(), applyRaceTime()).race();
    }

    private List<Car> createCar() {
        String carNames = InputView.inputCarName(scanner);

        return carRegister.registerCars(carNames);
    }

    private int applyRaceTime() {
        String inputTryTime = InputView.inputRaceTime(scanner);

        return racingTimeRegister.registerRacingTime(inputTryTime);
    }
}
