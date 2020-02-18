package racingcar.view;

import racingcar.domian.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int ZERO = 0;
    private static final String COLON = " : ";
    private static final String DASH = "-";

    public static void printNotice() {
        System.out.println("실행 결과");
    }

    public static void printCurrentRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);
            for (int i = ZERO; i < car.getDistance(); i++) {
                System.out.print(DASH);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printResult(List<Car> winners) {
        System.out.println(winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(",")) + "가 최종 우승했습니다.");
    }
}
