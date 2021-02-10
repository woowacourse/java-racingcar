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

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void race() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(getMaxDistance()))
                .collect(Collectors.toList());
    }
}
