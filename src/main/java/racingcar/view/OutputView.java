package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static final String ENTER = System.lineSeparator();
    public static final String IS = " : ";

    private OutputView() {}

    public static void printResult(Cars cars) {
        System.out.println(getResults(cars));
    }

    public static String getResults(Cars cars) {
        StringBuilder results = new StringBuilder();
        for (Car car : cars.getCars()) {
            results.append(getResult(car));
            results.append(ENTER);
        }
        return results.toString();
    }

    public static String getResult(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getName());
        result.append(IS);
        result.append(car.getLocationMarks());

        return result.toString();
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners.getWinnerNames());
    }
}
