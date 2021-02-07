package racingcar;

import java.util.Scanner;
import racingcar.domain.CarRacing;
import racingcar.domain.CarRacingBeforeSetter;
import racingcar.domain.CarRacingManager;
import racingcar.domain.CarRacingResult;
import racingcar.domain.CarRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        CarRacingManager carRacingManager = new CarRacingManager(scanner);
        carRacingManager.start();
    }
}
