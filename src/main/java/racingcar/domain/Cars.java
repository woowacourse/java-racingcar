package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Racers racers) {
        this.cars = new ArrayList<>(generateCars(racers));
    }

    private List<Car> generateCars(Racers racers) {
        return racers.streams()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getWinnerCars() {
        Car maxPositionCar = this.getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(maxPositionCar))
                .collect(Collectors.toList());
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }
}
