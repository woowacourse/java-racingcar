package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;

class Winner {
    private static final String DELIMITER = ",";

    String makeWinner(List<Car> cars) {
        int maxPosition = maxPosition(cars);
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
