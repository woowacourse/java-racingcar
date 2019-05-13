package racingcar;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Play {

    public static void printCarState(Cars cars, int turn) {
        OutputView.printResult();
        for (int i = 0; i < turn; i++) {
            moveCar(cars);
            OutputView.printState(getCarStates(cars));
        }
    }

    public static List<String> getCarStates(Cars cars) {
        List<String> carStates = new ArrayList<>();
        for (int i = 0, n = cars.getSize(); i < n; i++) {
            carStates.add(cars.getCarState(i));
        }
        return carStates;
    }

    public static void moveCar(Cars cars) {
        for (int i = 0, n = cars.getSize(); i < n; i++) {
            cars.updateCarMovement(i);
        }
    }
}
