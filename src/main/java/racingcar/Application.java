package racingcar;

import java.util.Scanner;
import racingcar.controller.CarController;

public class Application {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final CarController controller = new CarController(scanner);
        final String carNames = controller.scanCarNames();
    }

}
