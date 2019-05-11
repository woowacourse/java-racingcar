package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printPosition(List<Car> cars) {
        StringBuilder message = new StringBuilder();

        for (Car car : cars) {
            message.append(car.getName()).append(" : ").append(stringPosition(car)).append("\n");
        }

        System.out.print(message.toString());
    }

    private static String stringPosition(Car car) {
        StringBuilder message = new StringBuilder();

        for (int i = 1; i <= car.getPosition(); i++) {
            message.append("-");
        }

        return message.toString();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder message = new StringBuilder();

        for (Car car : winners) {
            message.append(car.getName()).append(", ");
        }

        message = new StringBuilder(message.substring(0, message.length() - 2));
        System.out.format("%s 이(가) 최종 우승했습니다.\n", message.toString());
    }
}
