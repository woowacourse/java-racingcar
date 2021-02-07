package racingcar;

import java.util.Scanner;
import racingcar.domain.CarRacing;
import racingcar.domain.CarRacingBeforeSetter;
import racingcar.domain.CarRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        CarRepository carRepository = new CarRepository();
        CarRacingBeforeSetter carRacingBeforeSetter
            = new CarRacingBeforeSetter(scanner, carRepository);
    }
}
