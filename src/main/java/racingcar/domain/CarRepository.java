package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

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

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static List<String> winnerNames() {
        return winners().stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toList());
    }

    public static List<Car> winners() {
        Position maxPosition = new Position(getMaxPosition());

        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private static int getMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
