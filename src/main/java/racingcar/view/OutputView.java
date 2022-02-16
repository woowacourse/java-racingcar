package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String NAME_POSITION_SEPARATOR = ":";
    public static final String BLANK = " ";
    public static final String POSITION_UNIT = "-";
    public static final String WINNERS_DELIMITER = ",";

    public static void printResult(final List<Car> cars) {
        for (final Car car : cars) {
            String result = car.getName() + BLANK + NAME_POSITION_SEPARATOR + BLANK;
            result += makePositionString(car.getPosition());
            System.out.println(result);
        }
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }

    static String makePositionString(final Position position) {
        return POSITION_UNIT.repeat(position.get());
    }

    public static void printWinners(final List<Car> winners) {
        final String result = winners.stream()
                .map(Car::getName)
                .map(CarName::toString)
                .collect(Collectors.joining(WINNERS_DELIMITER + BLANK));
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
