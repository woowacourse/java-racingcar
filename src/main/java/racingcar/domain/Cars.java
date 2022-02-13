package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> findAllCars() {
        return cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void clear() {
        cars.clear();
    }

    public void race() {
        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter((car) -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(null);
    }
}
