package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> cars;

    public Winner(final List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnerCarNames() {
        List<Car> winnerCars = getWinnerCars();
        return winnerCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private List<Car> getWinnerCars() {
        Car firstPrizeCar = getMaxDistance();
        return cars.stream()
                .filter(car -> car.isSamePositionCar(firstPrizeCar))
                .collect(Collectors.toList());
    }

    private Car getMaxDistance() {
        Collections.sort(cars);
        return cars.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(cars, winner.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
