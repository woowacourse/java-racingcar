package racingcar.view;

import racingcar.domain.WinnerNames;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RACING_RESULT_MESSAGE);
    }

    public static void printRacingRecords(List<String> racingRecords) {
        for (String racingRecord : racingRecords) {
            System.out.println(racingRecord);
        }
        System.out.println();
    }

    public static void printWinnerNames(WinnerNames winnerNames) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerNames.getWinnerNames());
        System.out.println(winners + WINNER_MESSAGE);
    }
}
