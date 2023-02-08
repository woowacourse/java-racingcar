package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCars(Car car) {
        cars.add(car);
    }

    public static void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
