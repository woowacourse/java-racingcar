package racingCar.view;

import racingCar.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MARK_POSITION = "-";

    public static void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static void printRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + MARK_POSITION.repeat(car.getPosition()));
        }
        System.out.print(System.lineSeparator());
    }

    public static void printWinners(List<String> winnerNames) {
        String winners = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winners + "(이)가 최종 우승했습니다.");
    }
}
