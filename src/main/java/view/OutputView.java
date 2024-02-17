package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WRITE_RESULT = "\n실행 결과";
    private static final String WRITE_WINNERS = "가 최종 우승했습니다.";


    public void writeResultMessage() {
        System.out.println(WRITE_RESULT);
    }
    public void writeRoundResult(String cars) {
        System.out.println(cars);
    }

    public void writeWinners(List<String> names) {
        String winners = names.stream().collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(winners + WRITE_WINNERS);
    }
}
