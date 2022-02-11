package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private int maxPosition;

    public List<String> getWinners(final List<Car> cars) {
        setMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private void setMaxPosition(List<Car> cars) {
        maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}

