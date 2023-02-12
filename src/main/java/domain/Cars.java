package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utils.RandomNumberGenerator;

public class Cars {

    private static final int CAN_NOT_FIND_MAX = -1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public Cars judgeWinners() {
        int maxPosition = findMaxPosition();

        List<Car> winner = cars.stream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .collect(Collectors.toList());

        return new Cars(winner);
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(CAN_NOT_FIND_MAX);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
