package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import utils.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public Long getStatus(Car car) {
        return car.getStatus();
    }

    public void move() {
        cars.forEach((car) -> car.move(randomNumberGenerator.generateRandomNumber()));
    }

    public List<Car> getWinners() {
        Long maxValue = getMaxValue();
        return cars.stream()
                .filter((car) -> Objects.equals(car.getStatus(), maxValue))
                .collect(Collectors.toList());
    }

    private Long getMaxValue() {
        return Collections.max(cars.stream()
                .map((Car::getStatus))
                .collect(Collectors.toList()));
    }
}
