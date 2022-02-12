package racingcar.view;

import java.util.List;

import racingcar.model.vo.Car;

public class OutputView {
    private static final String WINNERS_DELIMITER = ", ";
    private static final String WINNER_ANNOUNCE_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String RACE_PROGRESS_CHARACTER = "-";

    public static void printCurrentPosition(final List<Car> cars) {
        cars.forEach(OutputView::printRacingProgress);
        System.out.println();
    }

    private static void printRacingProgress(final Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private static String getPositionString(final int position) {
        return RACE_PROGRESS_CHARACTER.repeat(Math.max(0, position));
    }

    public static void printWinner(final List<String> winners) {
        System.out.printf(WINNER_ANNOUNCE_MESSAGE, String.join(WINNERS_DELIMITER, winners));
    }
}
