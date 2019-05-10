package racing.view;

import racing.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void showCarsPosition(List<Car> cars) {
        System.out.println();
        for (Car car : cars
        ) {
            System.out.println(car.statusString());
        }
    }

    public static void showChampion(List<Car> winners) {
        System.out.println();
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Car winner : winners) {
            stringJoiner.add(winner.getName());
        }
        System.out.println(stringJoiner.toString() + "가 최종 우승했습니다.");
    }

}
