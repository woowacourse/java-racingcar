package racingcar.view;

import java.util.List;

public class OutputView {
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarPosition(List<String> carsToString) {
        for (String carToString : carsToString) {
            System.out.println(carToString);
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_MESSAGE);
    }
}
