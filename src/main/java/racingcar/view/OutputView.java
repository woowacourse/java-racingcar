package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String WINNER_DESCRIPTION = "가 최종 우승했습니다.";
    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String NO_WINNER_DESCRIPTION = "최대 이동 거리가 0이므로 우승한 자동차가 없습니다.";
    private static final String NAME_INPUT_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_INPUT_DESCRIPTION = "시도할 회수는 몇회인가요?";

    private static final String POSITION_METER = "-";

    public static void printResultDescription() {
        System.out.println();
        System.out.println(RESULT_DESCRIPTION);
    }

    public static void printPosition(Map<String, Integer> carPositions) {
        StringBuilder sb = new StringBuilder();
        carPositions.forEach(
                (name, position) -> sb.append(name).append(":").append(POSITION_METER.repeat(position)).append("\n")
        );
        System.out.println(sb);
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printWinnerList(List<String> winners) {
        List<String> names = winners.stream()
                .toList();

        String winnerNames = String.join(", ", names);
        System.out.println(winnerNames + WINNER_DESCRIPTION);
    }

    public static void printNoWinner() {
        System.out.println(NO_WINNER_DESCRIPTION);
    }

    public static void printlnInputName() {
        System.out.println(NAME_INPUT_DESCRIPTION);
    }

    public static void printlnInputMoveCount() {
        System.out.println(MOVE_COUNT_INPUT_DESCRIPTION);
    }
}
