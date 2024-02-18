package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RESULT_SUBJECT = "실행 결과";
    private static final String WINNERS_SUFFIX = "%s가 최종 우승했습니다.";
    private static final String WINNERS_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printResultSubject() {
        System.out.println();
        System.out.println(RESULT_SUBJECT);
    }

    public static void printResult(final Map<String, Integer> result) {
        result.forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        IntStream.range(0, position)
                .forEach(i -> System.out.print('-'));
        System.out.println();
    }

    public static void printWinners(final List<String> winners) {
        System.out.printf(WINNERS_SUFFIX, String.join(WINNERS_DELIMITER, winners));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
