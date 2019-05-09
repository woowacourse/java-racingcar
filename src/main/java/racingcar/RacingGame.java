package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    List<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String names = inputView.InputCarNames();
        addCar(names);
    }

    private static void addCar(String names) {
        splitCar(names);
    }

    private static String[] splitCar(String names) {
        return names.split(",");
    }
}
