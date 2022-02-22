package racingcar.view;

import java.util.List;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {
    private static final String CAR_POSITION_BAR = "-";

    public static void printRaceResult() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printCars(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + CAR_POSITION_BAR.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(final List<String> names) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", names));
    }

    public static void printError(final Exception exception) {
        System.out.println(exception.getMessage());
    }
}
