package view;

import domain.Car;
import domain.Const;

import java.util.List;

public class OutputView {
    public static void outputGameResultTile() {
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    public static void outputGameResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + outputCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    private static String outputCarPosition(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return result;
    }

    public static void outputWinners(String winners) {
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
