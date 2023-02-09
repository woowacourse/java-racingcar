package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
