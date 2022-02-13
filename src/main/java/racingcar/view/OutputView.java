package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String NAME_POSITION_SEPARATOR = ":";
    public static final String BLANK = " ";
    public static final String POSITION_UNIT = "-";
    public static final String WINNERS_DELIMITER = ",";

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            String result = car.getName() + BLANK + NAME_POSITION_SEPARATOR + BLANK;
            result += makePositionString(car);
            System.out.println(result);
        }
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }

    static String makePositionString(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(POSITION_UNIT);
        }
        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        String result = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(WINNERS_DELIMITER + BLANK));
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
