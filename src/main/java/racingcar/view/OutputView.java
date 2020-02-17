package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingGameWinners;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName()).append(SEPARATOR);

        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(DISTANCE_INDICATOR);
        }

        return stringBuilder.toString();
    }

    public static void printWinners(RacingGameWinners winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winners.getWinners()
            .stream()
            .map(Car::getName)
            .collect(Collectors.joining(COMMA)));
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }
}
