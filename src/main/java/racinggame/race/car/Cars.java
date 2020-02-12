package racinggame.race.car;

import racinggame.race.car.engine.Engine;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void go(Engine randomEngine) {
        for (Car car : cars) {
            car.moveWith(randomEngine);
        }
    }

    public Winners getWinner() {
        int max = getMaxDistance();
        return new Winners(findWinningCarsByDistance(max));
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(AssertionError::new);
    }

    private List<Car> findWinningCarsByDistance(int max) {
        return this.cars.stream()
                .filter(car -> car.isWinner(max))
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return cars.spliterator();
    }
}
