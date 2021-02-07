package racingcar.domain.racing;

import java.util.Scanner;
import racingcar.domain.CarRepository;
import racingcar.domain.numbergenerator.RandomNumberGenerator;

public class CarRacingManager {
    private final CarRacingBeforeSetter carRacingBeforeSetter;
    private final CarRacing carRacing;

    public CarRacingManager(Scanner scanner) {
        CarRepository carRepository = new CarRepository();
        this.carRacingBeforeSetter = new CarRacingBeforeSetter(scanner, carRepository);
        this.carRacing = new CarRacing(carRepository, new RandomNumberGenerator());
    }

    public void start() {
        carRacingBeforeSetter.set();
        int racingTryTime = carRacingBeforeSetter.getRacingTryTime();
        carRacing.doAllRaces(racingTryTime);
    }
}
