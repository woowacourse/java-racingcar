package domain;

import utils.NormalRandomGenerator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.tryMove(NormalRandomGenerator.createRandomNumber());
        }
    }

    public Cars getWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> result = cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());

        return new Cars(result);
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .get();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
