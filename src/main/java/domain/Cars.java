package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars fromNames(List<CarName> carNames) {
        return from(carNames.stream()
                .map(carName -> Car.of(carName, Distance.ZERO))
                .collect(Collectors.toList()));
    }

    public Cars move(MoveStrategy strategy) {
        return new Cars(cars.stream()
                .map(car -> car.move(strategy))
                .collect(Collectors.toList())
        );
    }

    public Cars findWinners() {
        return from(MaxFinder.findAllMax(cars, Comparator.comparing(Car::getNumDistance)));
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
