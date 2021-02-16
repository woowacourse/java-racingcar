package racingCar;

import utils.RandomUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {


    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int findMaxDistance() {
        int maxNumber = 0;
        for (Car car : cars) {
            maxNumber = Math.max(maxNumber, car.getDistance());
        }
        return maxNumber;
    }

    public void moveCar(int[] randoms) {
        for (int i = 0;i<cars.size();i++) {
            cars.get(i).move(randoms[i]);
        }
    }

    public List<CarName> findWinners(int maxDistance) {
        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;

        Cars cars1 = (Cars) o;

        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }
}
