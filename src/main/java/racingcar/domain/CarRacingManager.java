package racingcar.domain;

import java.util.Scanner;

public class CarRacingManager {
    private final CarRacingBeforeSetter carRacingBeforeSetter;
    private final CarRacing carRacing;

    public CarRacingManager(Scanner scanner) {
        CarRepository carRepository = new CarRepository();
        this.carRacingBeforeSetter = new CarRacingBeforeSetter(scanner, carRepository);
        this.carRacing = new CarRacing(carRepository);
    }

    public void start() {
        carRacingBeforeSetter.set();
        int racingTryTime = carRacingBeforeSetter.getRacingTryTime();
        carRacing.start(racingTryTime);
    }
}
