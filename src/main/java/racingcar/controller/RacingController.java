package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRegister;
import racingcar.domain.CarRepository;
import racingcar.domain.RacingTimeRegister;
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

    private void race(int tryTime) {
        CarRepository.race(tryTime);
    }
}
