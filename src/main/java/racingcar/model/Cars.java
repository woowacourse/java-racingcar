package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MINIMUM_POSITION = 0;
    public static final String JOIN_BY_COMMA = ", ";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(car -> {
            car.move(RandomNumberGenerator.generate());
        });
    }

    public String findWinner() {
        int maxPosition = findMaxPosition();
        return findWinnerName(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(MINIMUM_POSITION);
    }

    private String findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }

    public List<Car> getCars() {
        return cars;
    }
}
