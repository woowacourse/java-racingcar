package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static void addCars(List<Car> copyingCars) {
        cars.addAll(copyingCars);
    }

    public static boolean deleteCar(String name) {
        return cars.removeIf(car -> Objects.equals(car.getName(), name));
    }

    public static List<Car> selectAllByPosition(int position) {
        return cars.stream()
                .filter(car -> car.checkPosition(position))
                .collect(Collectors.toList());
    }

    public static int getSize() {
        return cars.size();
    }
}
