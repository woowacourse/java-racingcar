package view;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static final String WIN_THE_GAME = "가 최종 우승했습니다.";

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
        }
        System.out.println();
    }

    public static void printCars(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        System.out.println(String.join(", ", carNames) + WIN_THE_GAME);
    }
}
