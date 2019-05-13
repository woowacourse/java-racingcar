package view;

import domain.Car;

import java.util.List;

public class OutputView {

    private static final String IS_WINNER = " 가 최종 우승했습니다.";

    public static void printWinners(List<Car> winners) {
        String[] names = winners.stream().map(Car::getName).toArray(String[]::new);
        System.out.println(String.join(",", names) + IS_WINNER);
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatusString());
        }
        System.out.println();
    }

    public static void printMassage(String msg) {
        System.out.println(msg);
    }
}
