package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RACING_RESULT_ANNOUNCE = "실행 결과";
    private static final String WINNERS_ANNOUNCE_FORMAT = "%s가 최종 우승했습니다.";

    public void writeResultMessage() {
        System.out.println(LINE_SEPARATOR + RACING_RESULT_ANNOUNCE);
    }

    public void writeRoundResult(List<String> racingResult) {
        String allResult = String.join(LINE_SEPARATOR, racingResult);
        System.out.println(allResult + LINE_SEPARATOR);
    }

    public void writeWinners(List<String> names) {
        String winners = names.stream().collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(String.format(WINNERS_ANNOUNCE_FORMAT, winners));
    }
}
