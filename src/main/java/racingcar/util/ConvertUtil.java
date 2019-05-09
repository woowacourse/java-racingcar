package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {
    public static List<String> getNamesOfCars(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
