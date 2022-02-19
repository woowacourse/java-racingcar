package racingcar.view;

import java.util.Map.Entry;
import racingcar.dto.WinnerNamesDto;
import racingcar.dto.RacingResultsDto;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RECORD_DELIMITER = " : ";
    private static final String POSITION_TO_STRING = "-";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RACING_RESULT_MESSAGE);
    }

    public static void printRacingResults(RacingResultsDto result) {
        result.getResults()
                .entrySet()
                .stream()
                .forEach(carResult -> System.out.println(getCarResults(carResult)));
        System.out.println();
    }

    private static String getCarResults(Entry<String, Integer> carResult) {
        return carResult.getKey() + RECORD_DELIMITER + POSITION_TO_STRING.repeat(carResult.getValue());
    }

    public static void printWinnerNames(WinnerNamesDto winnerNames) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerNames.getWinnerNames());
        System.out.println(winners + WINNER_MESSAGE);
    }
}
