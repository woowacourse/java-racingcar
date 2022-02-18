package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";
    private static final String SEPARATOR = ":";
    private static final String MOVE_SIGN = "-";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + SEPARATOR + MOVE_SIGN.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(String[] winners) {
        System.out.print(String.join(SPLIT_DELIMITER, winners));
        System.out.println(WINNER_SUFFIX);
    }

    public static void printError(String error) {
        System.out.println(ERROR_PREFIX + error);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
