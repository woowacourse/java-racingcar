package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Racers racers) {
        this.cars = generateCars(racers);
    }

    private List<Car> generateCars(Racers racers) {
        return racers.streams()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Car getMaxPositionCar() {
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
        return cars;
    }
}
