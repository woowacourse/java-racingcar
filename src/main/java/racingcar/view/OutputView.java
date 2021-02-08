package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_OF_RESULT_NOTICE = "실행 결과";
    private static final String DELIMITER_OF_NAME_AND_POSITION = " : ";
    private static final String DELIMITER_OF_WINNERS = ", ";
    private static final String OUTPUT_OF_RETRY = "다시 입력해주세요";
    private static final String OUTPUT_OF_WINNERS = "가 최종 우승했습니다.";

    public static void printStartRace() {
        System.out.println(OUTPUT_OF_RESULT_NOTICE);
    }

    public static void printCarInfo(String name, String position) {
        System.out.println(name + DELIMITER_OF_NAME_AND_POSITION + position);
    }

    public static void printOneLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winnersName) {
        System.out.println(String.join(DELIMITER_OF_WINNERS, winnersName) + OUTPUT_OF_WINNERS);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + OUTPUT_OF_RETRY);
    }
}
