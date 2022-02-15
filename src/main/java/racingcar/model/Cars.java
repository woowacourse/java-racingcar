package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_POSITION = 0;
    private static final String JOIN_BY_COMMA = ", ";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(position -> position)
                .max().orElse(MINIMUM_POSITION);
    }

    public String findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }
}
