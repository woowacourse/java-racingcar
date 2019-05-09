package utils;

import domain.Car;

import java.util.ArrayList;

public class OutputUtil {

    public static void printMessage(String message) {
        System.out.println(message);
    }


    public static void printPosition(String name, int position) {
        StringBuilder result = new StringBuilder(name + " : ");

        for (int i = 1; i <= position; i++) {
            result.append("-");
        }

        System.out.println(result);
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
