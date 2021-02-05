package racingcar;

import racingcar.controller.RacingController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingController carRacingManager = new RacingController(scanner);
        carRacingManager.start();
    }
}
