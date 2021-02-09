package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
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

    public List<Car> getWinnerCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(maxPositionCar))
                .collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            car.movePosition(RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
    }

    public List<Car> toList() {
        return cars;
    }
}
