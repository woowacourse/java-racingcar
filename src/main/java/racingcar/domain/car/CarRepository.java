package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCars(List<Car> copyingCars) {
        cars.addAll(copyingCars);
    }

    public static String collectWinners() {
        return CarRepository.cars().stream()
                .filter(car -> car.isMaxPosition(CarRepository.selectMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private static int selectMaxPosition() {
        return cars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
