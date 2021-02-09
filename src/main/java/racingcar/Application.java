package racingcar;

import racingcar.controller.RacingController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        RacingController carRacingController = new RacingController(scanner);
        carRacingController.start();
    }
}
