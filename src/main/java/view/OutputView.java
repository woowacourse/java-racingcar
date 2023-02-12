package view;

import dto.Result;

import java.util.List;

public class OutputView {

    public static final String ERROR = "[ERROR]";
    public static final String MOVING_RESULT_MESSAGE = System.lineSeparator() + "실행 결과";
    public static final String RESULT_MESSAGE_FORMAT = "%s : %s";
    public static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";
    public static final String DELIMITER = ", ";
    public static final String POSITION_BAR = "-";

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void printResultMessage() {
        System.out.println(MOVING_RESULT_MESSAGE);
    }

    public void printResult(Result result) {
        result.forEach((name, position)
                -> System.out.printf(RESULT_MESSAGE_FORMAT, makePositionBar(position), name)
        );
        System.out.println();
    }

    private static StringBuilder makePositionBar(Long position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < position; count++) {
            stringBuilder.append(POSITION_BAR);
        }
        return stringBuilder;
    }

    public void printWinners(List<String> winnerNames) {
        System.out.printf(WINNER_MESSAGE_FORMAT, combineNamesWithDelimiter(winnerNames));
    }

    private static String combineNamesWithDelimiter(List<String> names) {
        return String.join(DELIMITER, names);
    }
}
