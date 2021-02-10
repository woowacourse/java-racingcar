package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }

    public List<String> winnerNames() {
        return winners().stream()
                .map(Car::getValueOfName)
                .collect(Collectors.toList());
    }

    public List<Car> winners() {
        Position maxPosition = new Position(getMaxPosition());

        return cars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars().stream()
                .mapToInt(Car::getValueOfPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
