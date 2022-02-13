package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String STATUS_MESSAGE = "\n실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printStatusMessage() {
        System.out.println(STATUS_MESSAGE);
    }

    public static void printStatus(String carsStatus) {
        System.out.println(carsStatus);
        System.out.println();
    }

    public static void printResult(List<String> winners) {
        System.out.println(String.join(WINNER_NAME_DELIMITER, winners) + END_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + "\n");
    }
}
