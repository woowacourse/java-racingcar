package racingCar;

import java.util.Scanner;
import racingCar.controller.GameController;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);
        gameController.play();
    }
}
