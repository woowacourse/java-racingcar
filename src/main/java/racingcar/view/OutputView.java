package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String CARS_STATE_FORMAT = "%s : %s"; // ex) name : ---
    private static final String BAR = "-";

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        return String.format(CARS_STATE_FORMAT,car.getName(),getBars(car.getPosition()));
    }

    private static String getBars(int count) {
        return BAR .repeat(Math.max(0, count));
    }
}
