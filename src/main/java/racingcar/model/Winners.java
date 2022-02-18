package racingcar.model;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Winners {
    public static final int MINIMUM_POSITION = 0;
    public static final String JOIN_BY_COMMA = ", ";

    private final Cars cars;

    public Winners(Cars cars) {
        this.cars = cars;
    }

    public String findName() {
        return cars.getCars().stream()
                .filter(car -> findMaxPosition() == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }

    private int findMaxPosition() {
        return cars.getCars().stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(MINIMUM_POSITION);
    }
}
