package racingcar;

import static java.lang.String.join;

import java.util.List;

public class OutputView {

    private static final String PRINT_WINNER_DELIMITER = ", ";
    private static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public OutputView() {
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(join(PRINT_WINNER_DELIMITER, winnerNames) + PRINT_WINNER_MESSAGE);
    }
}