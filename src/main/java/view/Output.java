package view;

import domain.Car;
import java.util.List;

public class Output {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEachCarDistance(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public static <Winner> void printWinner(Winner winner) {
        System.out.println(winner.toString());
    }

}
