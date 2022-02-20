package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    private static final String DELIMITER = " : ";
    private static final String DISTANCE = "-";

    public static void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + DELIMITER + DISTANCE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printChampionList(List<String> champions) {
        String championNames = String.join(", ", champions);
        System.out.println(championNames + "가 최종 우승했습니다.");
    }
}
