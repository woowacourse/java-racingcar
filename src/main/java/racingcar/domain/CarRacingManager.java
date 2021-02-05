package racingcar.domain;

import racingcar.view.InputView;

import java.util.List;
import java.util.Scanner;

public class CarRacingManager {

    private final Scanner scanner;
    private final CarRegister carRegister;
    private final RacingTimeRegister racingTimeRegister;

    public CarRacingManager(Scanner scanner) {
        this.scanner = scanner;
        this.carRegister = new CarRegister();
        this.racingTimeRegister = new RacingTimeRegister();
    }

    public void start() {
        String carNames = InputView.inputCarName(scanner);
        List<Car> cars = carRegister.registerCars(carNames);
        CarRepository.saveAll(cars);

        String inputTryTime = InputView.inputRaceTime(scanner);
        int tryTime = racingTimeRegister.registerRacingTime(inputTryTime);
        CarRepository.race(tryTime);
    }
}
