package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final String RESULT_PREFIX = "실행결과";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";
    private static final String SEPARATOR = ":";
    private static final String MOVE_SIGN = "-";

    public static void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

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

}
