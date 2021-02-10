package racingcargame.domain;

import racingcargame.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private int maxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void race() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }

    public List<Car> winners() {
        return cars.stream()
                .filter(car -> car.isWinner(maxDistance()))
                .collect(Collectors.toList());
    }
}
