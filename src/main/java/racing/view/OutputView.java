package racing.view;

import racing.game.Car;

import java.util.List;

public class OutputView {

    public static void showCarsPosition(List<Car> cars) {
        for (Car car : cars
        ) {
            car.showPosition();
        }

    }

}
