package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_CHANGER = "\n";
    private static final String SEPARATOR = " : ";
    private static final String DISTANCE_INDICATOR = "-";
    private static final String COMMA = ", ";

    public static void printStatus(List<Car> cars) {
        System.out.println(cars.stream()
                .map(OutputView::getStatus)
                .collect(Collectors.joining(LINE_CHANGER)));
    }

    public static void printWinners(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA)));
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    private static String getStatus(Car car) {
        StringBuilder SB = new StringBuilder();

        SB.append(car.getName());
        SB.append(SEPARATOR);
        for (int i = 0; i < car.getDistance(); i++) {
            SB.append(DISTANCE_INDICATOR);
        }
        return SB.toString();
    }
}
