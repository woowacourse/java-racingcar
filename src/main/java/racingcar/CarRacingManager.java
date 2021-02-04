package racingcar;

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
        String carNames = InputView.printInputCarName(scanner);
        List<Car> cars = carRegister.registerCars(carNames);
        CarRepository.saveAll(cars);

        String tryTime = InputView.printInputRaceTime(scanner);
        racingTimeRegister.registerRacingTime(tryTime);
    }
}
