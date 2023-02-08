package view;

import domain.Car;
import domain.Cars;

import java.util.StringJoiner;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "";
    private static final String SUFFIX = "";
    private static final String WINNER_MSG = "%s가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printState(Cars cars) {
        System.out.println(cars);
    }

    public static void printWinners(Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (Car car : cars) {
            stringJoiner.add(car.getName());
        }

        System.out.println(String.format(WINNER_MSG, stringJoiner));
    }
}
