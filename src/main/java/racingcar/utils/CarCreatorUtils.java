package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarCreatorUtils {

    private CarCreatorUtils() {
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
