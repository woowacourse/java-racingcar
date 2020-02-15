package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    private static final String COMMA = ",";

    public static void printRoundResult(Car car) {
        System.out.println(car);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다.");
    }

}
