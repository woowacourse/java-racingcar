package racing.view;

import racing.model.Car;
import racing.model.Winner;

import java.util.List;

public class OutputView {
    private final static String MSG_WIN = "가 최종 우승했습니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    private static void print(Car car) {
        StringBuilder currentLocation = new StringBuilder();
        currentLocation.append(String.format("%-5s : ", car.getName()));
        for (int i = 0; i < car.getPosition(); i++) {
            currentLocation.append("-");
        }
        System.out.println(currentLocation.toString());
    }

    public static void print(List<Car> cars){
        for(Car car: cars){
            print(car);
        }
        System.out.println();
    }

    public static void print(Winner winner) {
        String winnerNames = String.join(", ", winner.getWinners());
        System.out.println(winnerNames + MSG_WIN);
    }
}
