package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_OPENING_MESSAGE = "실행 결과";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String UNIT_POSITION_SIGN = "-";
    private static final String WINNERS_PREFIX = "";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String WINNERS_SUFFIX = "가 최종 우승했습니다.";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printResultOpening() {
        printBlankLine();
        System.out.println(RESULT_OPENING_MESSAGE);
    }

    public void printRaceResult(Map<String, Integer> raceResult) {
        raceResult.forEach((carName, position) -> System.out.println(generateRaceResultFormat(carName, position)));
        printBlankLine();
    }

    private String generateRaceResultFormat(String name, Integer position) {
        return name + NAME_POSITION_DELIMITER + UNIT_POSITION_SIGN.repeat(position);
    }

    public void printWinners(List<String> winners) {
        System.out.println(generateWinnersFormat(winners));
    }

    private String generateWinnersFormat(List<String> winners) {
        return winners.stream()
                .collect(Collectors.joining(WINNERS_DELIMITER, WINNERS_PREFIX, WINNERS_SUFFIX));
    }

    public void printError(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
