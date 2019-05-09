package racing.view;

import racing.game.Car;

import java.util.List;

public class OutputView {

    public static void showCarsPosition(List<Car> cars) {
        System.out.println();
        for (Car car : cars
        ) {
            System.out.println(car.showPosition());
        }

    }

}
