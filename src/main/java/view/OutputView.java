package view;

import domain.Car;
import domain.Winner;

import java.util.List;

public class OutputView {
    public static void printPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void printWinnerName(List<Car> cars) {
        Winner winner = new Winner(cars);
        String result = String.join(",", winner.getWinnerList());
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
