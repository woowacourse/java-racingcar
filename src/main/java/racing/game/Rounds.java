package racing.game;


import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
    private static final int BOUNDARY = 4;


    private static int getRandomValue() {

        return (int) (Math.random() * 10);
    }

    public static boolean canMove(int randomValue) {
        if (randomValue >= BOUNDARY) {
            return true;
        }
        return false;
    }

    public static void doRound(List<Car> cars) {
        for (Car car : cars) {
            if (canMove(getRandomValue())) {
                car.move();
            }
        }
        OutputView.showCarsPosition(cars);

    }

}
