package racingcar;

import java.util.List;
import java.util.Scanner;
import racingcar.controller.CarController;
import racingcar.domain.Car;

public class Application {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final CarController controller = new CarController(scanner);
        final String carNames = controller.scanCarNames();
        final List<Car> cars = controller.saveCars(carNames);
        final int racingCnt = controller.scanRacingCnt();
    }

}
