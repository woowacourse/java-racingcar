package domain;

import utils.MovingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(Cars cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new Car(car));
        }
        this.cars = result;
    }

    public void moveCars(MovingStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy.movable());
        }
    }

    public Cars getWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> result = cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toUnmodifiableList());

        return new Cars(result);
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .orElseGet(Position::create);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
