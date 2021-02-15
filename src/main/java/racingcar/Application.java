package racingcar;

import racingcar.controller.RacingGameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingGameController controller = new RacingGameController();

        controller.start(scanner);

        scanner.close();
    }
}