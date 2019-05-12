package view;

import domain.Car;
import domain.GameResult;
import domain.WinnerCars;

import java.util.List;

public class OutputView {
    public static void printPosition(GameResult gameResult) {
        StringBuilder message = new StringBuilder();
        List<Car> cars = gameResult.getCars();

        for (Car car : cars) {
            message.append(car.getName()).append(" : ").append(currentPosition(car)).append("\n");
        }

        System.out.print(message.toString());
    }

    private static String currentPosition(Car car) {
        StringBuilder positionString = new StringBuilder();

        for (int i = 1; i <= car.getPosition(); i++) {
            positionString.append("-");
        }

        return positionString.toString();
    }

    public static void printWinners(WinnerCars winnerCars) {
        StringBuilder message = new StringBuilder();
        List<Car> winners = winnerCars.getWinnerCars();

        for (Car car : winners) {
            message.append(car.getName()).append(", ");
        }

        message = new StringBuilder(message.substring(0, message.length() - 2));
        System.out.format("%s 이(가) 최종 우승했습니다.\n", message.toString());
    }
}
