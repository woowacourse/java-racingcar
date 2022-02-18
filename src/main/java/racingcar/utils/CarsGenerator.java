package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarsGenerator {

    public static List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
