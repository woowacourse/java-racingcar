package view;

import domain.Car;

import java.util.ArrayList;

public class OutputView {
    public static void printPosition(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void printWinners(ArrayList<Car> winners) {
        String winnerNames = "";
        String message;

        for (Car winner : winners) {
            winnerNames = winner.appendCarName(winnerNames);
        }

        message = winnerNames.substring(0, winnerNames.length() - 2);
        System.out.format("%s 이(가) 최종 우승했습니다.\n", message);
    }
}
