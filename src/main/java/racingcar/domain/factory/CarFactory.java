package racingcar.domain.factory;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String CAR_NAME_DELIMITER = ",";

    private CarFactory() { }

    public static List<Car> from(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
