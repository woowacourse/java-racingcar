package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static void addCars(List<Car> copyingCars) {
        cars.addAll(copyingCars);
    }

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static List<Car> collectWinners() {
        return CarRepository.cars().stream()
                .filter(car -> car.isMaxPosition(selectMaxPosition()))
                .collect(Collectors.toList());
    }

    public static int selectMaxPosition() {
        return cars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
