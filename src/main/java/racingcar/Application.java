package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import racingcar.controller.CarController;
import racingcar.domain.Car;

public class Application {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final CarController controller = new CarController(scanner);
        final String carNames = controller.scanCarNames();
        List<Car> cars = controller.saveCars(carNames);
        final int racingCnt = controller.scanRacingCnt();

        controller.printResultInitMessage();
        for (int i = 0; i < racingCnt; i++) {
            cars = controller.race(cars);
            Map<String, Integer> carNameAndPositions = getCarNameAndPositions(cars);
            controller.printResult(carNameAndPositions);
        }
        final List<String> winners = controller.getWinners(cars);
        controller.printWinners(winners);
    }

    private static Map<String, Integer> getCarNameAndPositions(final List<Car> cars) {
        Map<String, Integer> carNameAndPositions = new LinkedHashMap<>();
        for (Car car : cars) {
            carNameAndPositions.put(car.getName(), car.getPosition());
        }
        return carNameAndPositions;
    }

}
