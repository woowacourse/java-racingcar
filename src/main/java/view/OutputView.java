package view;

import domain.Car;
import domain.Const;

import java.util.List;
import java.util.Objects;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class OutputView {
    public static void outputGameResultTile() {
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    public static void outputGameResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(String winners) {
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
