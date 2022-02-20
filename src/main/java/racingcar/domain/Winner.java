package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<Name> findWinners() {
        return findCoWinners(findWinner());
    }

    private Car findWinner() {
        return cars.stream()
            .max(Car::comparePosition)
            .orElseThrow(NoSuchElementException::new);
    }

    private List<Name> findCoWinners(Car firstCar) {
        return cars.stream()
            .filter(car -> car.isEqualPosition(firstCar))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
