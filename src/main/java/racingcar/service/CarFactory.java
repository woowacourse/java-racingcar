package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarFactory {

    public static List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
