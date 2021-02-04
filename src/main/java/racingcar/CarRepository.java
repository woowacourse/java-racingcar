package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    public static void save(Car car) {
        cars.add(car);
    }

    public static void saveAll(List<Car> carsToSave) {
        cars.addAll(carsToSave);
    }

    public static void deleteAll() {
        cars.clear();
    }

    public static List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }

    private static int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
