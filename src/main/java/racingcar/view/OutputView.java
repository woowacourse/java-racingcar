package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;


public class OutputView {
    private static final String CAR_POSITION_MESSAGE = "%s : %s";
    private static final String CAR_POSITION_BAR = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printMoveResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarPosition(final String carName, final int position) {
        String positionBar = createPositionBar(position);
        System.out.printf((CAR_POSITION_MESSAGE) + "%n", carName, positionBar);
    }

    private String createPositionBar(final int position) {
        return CAR_POSITION_BAR.repeat(position);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        final StringJoiner winnerJoiner = new StringJoiner(WINNER_DELIMITER);
        for (String winner : winners) {
            winnerJoiner.add(winner);
        }

        System.out.printf("%s가 최종 우승했습니다.%n", winnerJoiner);
    }
}
