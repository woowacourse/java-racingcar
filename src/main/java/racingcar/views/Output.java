package racingcar.views;

import java.util.List;

public class Output {

    private static final String TURN_RESULT = "\n실행결과";
    private static final String WINNER = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println(TURN_RESULT);
    }

    public static void printTurnResult(final List<String> turnResult) {
        turnResult.forEach(System.out::println);
        System.out.print(System.lineSeparator());
    }

    public static void printWinners(final String winners) {
        System.out.print(winners + WINNER);
    }
}
