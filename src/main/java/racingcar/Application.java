package racingcar;

import java.util.Scanner;
import racingcar.domain.racing.CarRacingManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        CarRacingManager carRacingManager = new CarRacingManager(scanner);
        carRacingManager.start();
    }
}
