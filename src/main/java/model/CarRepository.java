package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.RandomUtils;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void moveCars() {
        cars.stream()
            .filter(car -> car.getRandomNumber() >= 4)
            .forEach(car -> car.movePosition());
    }
}
