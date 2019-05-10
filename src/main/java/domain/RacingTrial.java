package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingTrial {
    private static final MoveStrategy moveStrategy = new MoveStrategy(new Random());

    public ArrayList<Car> runTrial(ArrayList<Car> cars) {
        // 각각 차들에 대해서 움직이기
        ArrayList<Car> carsForMoving = new ArrayList(cars.stream()
                .filter((Car car) -> moveStrategy.isMove()).collect(Collectors.toList()));

        for (Car car : carsForMoving) {
            car.move();
        }

        return cars;
    }
}
