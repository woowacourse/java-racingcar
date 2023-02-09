package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_HEAD = "실행 결과";
    private static final String MOVE_UNIT = "-";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";

    public OutputView() {
    }

    public void printInitialStatus(final Map<String, Integer> initialStatus) {
        System.out.println("\n" + RESULT_HEAD);
        printMoveResult(initialStatus);
    }

    public void printMoveResult(final Map<String, Integer> result) {
        result.entrySet()
            .forEach(this::printEachResult);
        System.out.println();
    }

    public void printWinner(final List<String> winners) {
        System.out.printf(WINNER_FORMAT + "\n", String.join(WINNER_DELIMITER, winners));
    }

    private void printEachResult(final Map.Entry<String, Integer> carMoveCount) {
        System.out.printf(RESULT_FORMAT + "\n", carMoveCount.getKey(),
            generateMoveStatus(carMoveCount.getValue()));
    }

    private String generateMoveStatus(final int moveCount) {
        return MOVE_UNIT.repeat(Math.max(0, moveCount));
    }
}
