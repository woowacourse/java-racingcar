package racinggame.race.car;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
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
                .filter(car -> car.isSameDistance(max))
                .collect(toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
