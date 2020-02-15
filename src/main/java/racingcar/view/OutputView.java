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
                .collect(Collectors.joining(LINE_CHANGER))
            + LINE_CHANGER);
    }

    private static String getStatus(Car car) {
        StringBuilder SB = new StringBuilder();
        SB.append(car.getName()).append(SEPARATOR);

        for (int i = 0; i < car.getDistance(); i++) {
            SB.append(DISTANCE_INDICATOR);
        }

        return SB.toString();
    }

    public static void printWinners(List<Car> cars) {
        StringBuilder SB = new StringBuilder();
        SB.append(cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA)));
        SB.append("가 최종 우승했습니다.");
        System.out.println(SB.toString());
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }
}
