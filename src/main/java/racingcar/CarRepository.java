package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    public static void updateCars(Car car) {
        cars.add(car);
    }

    public static List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }
}
