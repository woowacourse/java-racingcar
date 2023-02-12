package domain;

import java.util.List;
import java.util.stream.Collectors;
import strategy.MovingStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(final MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy.getRandomNumber());
        }
    }

    public List<String> getTotalStatus() {
        return cars.stream()
            .map(Car::getCarStatus)
            .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        return cars.stream()
            .filter(x -> x.getPosition() == findMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compareTo)
            .orElse(0);
    }
}
