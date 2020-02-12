package racing.car;

import racing.car.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void go(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.go(randomNumberGenerator);
        }
    }

    public List<Car> getWinner() {
        int max = getMaxDistance();
        return getWinnerByMaxDistance(max);
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .map(Car::getDistance)
                .sorted()
                .unordered()
                .findFirst()
                .orElseThrow(AssertionError::new);
    }

    private List<Car> getWinnerByMaxDistance(int max) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (max == cars.get(i).getDistance()) {
                result.add(cars.get(i));
            }
        }
        return result;
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
