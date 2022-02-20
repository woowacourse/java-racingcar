package racingcar.view;

import java.util.List;

public class WinnersOutputView {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printWinners(List<String> winnerNames) {
        System.out.println(joinWinnerNames(winnerNames) + WINNER_MESSAGE);
    }

    private static String joinWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_NAME_DELIMITER, winnerNames);
    }
}
