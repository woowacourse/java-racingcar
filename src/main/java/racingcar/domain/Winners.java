package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int MIN_POSITION = 0;

    private final List<Car> winners;
    private final int maxPosition;

    public Winners(List<Car> cars) {
        maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }


    public int getMaxPosition() {
        return maxPosition;
    }

    public List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

}
