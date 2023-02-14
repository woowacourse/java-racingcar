package view;

import domain.model.Name;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_HEAD = "실행 결과";
    private static final String MOVE_UNIT = "-";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";

    public OutputView() {
    }

    public void printInitialStatus(final Map<Name, Integer> initialStatus) {
        System.out.println("\n" + RESULT_HEAD);
        printMoveResult(initialStatus);
    }

    public void printMoveResult(final Map<Name, Integer> result) {
        result.entrySet()
            .forEach(this::printEachResult);
        System.out.println();
    }

    public void printWinner(final List<Name> winners) {
        List<String> names = winners.stream().map(Name::toString).collect(Collectors.toList());
        System.out.printf(WINNER_FORMAT + "\n", String.join(WINNER_DELIMITER, names));
    }

    private void printEachResult(final Map.Entry<Name, Integer> carMoveCount) {
        System.out.printf(RESULT_FORMAT + "\n", carMoveCount.getKey().toString(),
            generateMoveStatus(carMoveCount.getValue()));
    }

    private String generateMoveStatus(final int moveCount) {
        return MOVE_UNIT.repeat(Math.max(0, moveCount));
    }
}
