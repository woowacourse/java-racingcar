package racingcar;

import racingcar.controller.RacingCarController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RacingCarController racingCarController = new RacingCarController(scanner);
        racingCarController.generateCars();
        racingCarController.receiveTurns();
        racingCarController.playGame();
        racingCarController.endGame();
    }
}
