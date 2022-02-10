package racingcar.view;

import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarsPosition(Cars cars) {
        System.out.print(cars);
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADER_MESSAGE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_MESSAGE);
    }
}
