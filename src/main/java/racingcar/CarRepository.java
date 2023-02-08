package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    public static void updateCars(Car car) {
        cars.add(car);
    }

    public static List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public static List<String> findSamePositionWith(int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
