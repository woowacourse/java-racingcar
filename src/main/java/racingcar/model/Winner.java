package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public List<String> getWinners(final List<Car> cars) {
        return cars.stream()
            .filter(car -> car.getPosition() == setMaxPosition(cars))
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private int setMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}

