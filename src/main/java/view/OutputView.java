package view;

import static constant.Messages.*;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printRound() {
        System.out.println(INPUT_ROUND);
    }

    public static void printRoundResult() {
        System.out.println(GAME_RESULT);
    }

    public static void printScore(List<Car> carList) {
        for (Car car : carList) {
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
