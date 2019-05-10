package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;

class Winner {
    List<String> makeWinner(List<Car> cars) {
        int maxPosition = maxPosition(cars);
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
