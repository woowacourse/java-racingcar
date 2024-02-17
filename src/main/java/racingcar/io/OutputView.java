package racingcar.io;

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

    public void printCarsPosition(final List<Car> cars) {
        for (Car car : cars) {
            String positionBar = createPositionBar(car.getPosition());
            System.out.printf((CAR_POSITION_MESSAGE) + "%n", car.getName(), positionBar);
        }
        System.out.println();
    }

    private String createPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append(CAR_POSITION_BAR);
        }
        return positionBar.toString();
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerJoiner = new StringJoiner(WINNER_DELIMITER);
        for (String winner : winners) {
            winnerJoiner.add(winner);
        }

        System.out.printf("%s가 최종 우승했습니다.%n", winnerJoiner);
    }
}
