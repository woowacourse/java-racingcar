package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CloneUtils {
    private CloneUtils() {
    }

    public static List<Car> copyAllCars(List<Car> cars) {
        return cars.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }
}
