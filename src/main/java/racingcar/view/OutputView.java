package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEWLINE + "실행 결과";
    private static final String COLON = " : ";
    private static final String POSITION_EXPRESSION_SYMBOL = "-";
    private static final String WINNERS_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";
    private static final String ERROR_SUFFIX = "[ERROR]";
    private static final String ERROR_MESSAGE_FORMAT = "%s %s";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(Map<String, Integer> carInformation) {
        carInformation.forEach(OutputView::printCarInformation);
        System.out.println();
    }

    private static void printCarInformation(String name, int position) {
        StringBuilder informationBuilder = new StringBuilder();

        informationBuilder.append(name)
                .append(COLON)
                .append(POSITION_EXPRESSION_SYMBOL.repeat(position));

        System.out.println(informationBuilder);
    }

    public static void printWinners(List<CarDto> winners) {
        List<String> winnerNames = findWinnerNames(winners);
        String names = String.join(WINNER_DELIMITER, winnerNames);

        System.out.println(names.concat(WINNERS_MESSAGE));
    }

    private static List<String> findWinnerNames(List<CarDto> winners) {
        return winners.stream()
                .map(CarDto::getName)
                .toList();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, ERROR_SUFFIX, errorMessage));
    }
}
