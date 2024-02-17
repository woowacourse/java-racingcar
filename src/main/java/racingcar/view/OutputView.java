package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String WINNER_DESCRIPTION = "가 최종 우승했습니다.";
    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String NO_WINNER_DESCRIPTION = "최대 이동 거리가 0이므로 우승한 자동차가 없습니다.";
    private static final String POSITION_METER = "-";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printResultDescription() {
        System.out.println();
        System.out.println(RESULT_DESCRIPTION);
    }

    private static String createRoundResponseMessage(Map<String, Integer> roundResponse) {
        StringBuilder sb = new StringBuilder();
        roundResponse.forEach(
                (name, position) -> sb.append(name).append(":").append(POSITION_METER.repeat(position)).append(NEW_LINE)
        );
        sb.append(NEW_LINE);
        return sb.toString();
    }

    public static void printPosition(List<Map<String, Integer>> raceResponse) {
        StringBuilder sb = new StringBuilder();
        raceResponse.forEach(r -> sb.append(createRoundResponseMessage(r)));
        System.out.print(sb);
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printWinnerList(List<String> winners) {
        List<String> names = winners.stream().toList();
        String winnerNames = String.join(CAR_NAME_DELIMITER, names);
        System.out.println(winnerNames + WINNER_DESCRIPTION);
    }

    public static void printNoWinner() {
        System.out.println(NO_WINNER_DESCRIPTION);
    }
}
