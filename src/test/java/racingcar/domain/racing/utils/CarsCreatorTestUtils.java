package racingcar.domain.racing.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarsCreatorTestUtils {
    private static final int CARS_SIZE = 10;

    public static List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < CARS_SIZE; i++) {
            cars.add(new Car(String.valueOf(i)));
        }
        return cars;
    }
}
