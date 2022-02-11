package racingcar.view;

import java.util.List;

public class OutputView {
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    public static final String WINNER_JOIN_DELIMITER = ", ";

    public static void printCarPosition(List<String> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_JOIN_DELIMITER, winners) + WINNER_MESSAGE);
    }
}
