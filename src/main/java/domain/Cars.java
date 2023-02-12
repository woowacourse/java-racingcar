package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int CAN_NOT_FIND_MAX = -1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public Winners judgeWinners() {
        int maxPosition = findMaxPosition();

        List<String> winners = cars.stream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());

        return new Winners(winners);
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
