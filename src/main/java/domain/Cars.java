package domain;

import utils.RandomGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(RandomGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }

    public Cars getWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> result = cars.stream()
                .filter(m -> m.getPosition().equals(maxPosition))
                .collect(Collectors.toList());

        return new Cars(result);
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .sorted()
                .findFirst()
                .get();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
