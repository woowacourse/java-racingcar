package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void printRoundResult(Cars cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars.getCars()) {
            System.out.println(car.getProgress());
        }
        System.out.println();
    }

    public static void printChampionList(Cars cars) {
        String championNames = String.join(", ", cars.getChampions());
        System.out.println(championNames + "가 최종 우승했습니다.");
    }
}
