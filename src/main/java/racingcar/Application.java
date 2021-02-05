package racingcar;

import racingcar.domain.CarRacingManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        CarRacingManager carRacingManager = new CarRacingManager(scanner);
        carRacingManager.start();
    }
}
