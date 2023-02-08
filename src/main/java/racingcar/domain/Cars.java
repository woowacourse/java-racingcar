package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(String carNames) {
        this.cars = splitCarNames(carNames);
    }

    public static Cars of(String carNames) {
        return new Cars(carNames);
    }

    private List<Car> splitCarNames(String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
