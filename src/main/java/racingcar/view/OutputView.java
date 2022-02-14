package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String DELIMITER = " : ";
    private static final String DISTANCE = "-";

    public static void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + DELIMITER + DISTANCE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printChampionList(Cars cars) {
        String championNames = String.join(", ", cars.getChampions());
        System.out.println(championNames + "가 최종 우승했습니다.");
    }
}
