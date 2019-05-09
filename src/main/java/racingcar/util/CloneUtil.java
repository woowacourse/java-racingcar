package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CloneUtil {
    private CloneUtil() {}

    public static List<Car> cloneCarList(List<Car> cars) {
        return cars.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }
}
