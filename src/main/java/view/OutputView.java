package view;

import domain.Car;
import domain.Winner;

import java.util.List;

public class OutputView {
    public static void printTrace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinnerName(List<Car> cars) {
        Winner winner = new Winner(cars);
        String winnerNames = String.join(",", winner.getWinners());

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
