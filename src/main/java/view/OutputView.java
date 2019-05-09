package view;

import domain.Car;

import java.util.ArrayList;

public class OutputView {

    public static void printPosition(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    public static void printWinners(ArrayList<Car> winnerList) {
        String winnerNames = "";
        String message;

        for (Car winner : winnerList) {
            winnerNames = winner.appendCarName(winnerNames);
        }

        message = winnerNames.substring(0, winnerNames.length() - 2);
        System.out.format("%s 이(가) 최종 우승했습니다.\n", message);
    }
}
