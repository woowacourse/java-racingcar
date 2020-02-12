package racing.car;

import racing.car.numbergenerator.NumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Winners getWinner() {
        int max = getMaxDistance();
        return new Winners(getWinnerByMaxDistance(max));
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(AssertionError::new);
    }

    private List<Car> getWinnerByMaxDistance(int max) {
        return this.cars.stream()
                .filter(car -> car.isWinner(max))
                .collect(Collectors.toList());
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public void go(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.go(randomNumberGenerator);
        }
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
}
