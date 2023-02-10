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
        return car.getPosition();
    }

    public void move() {
        cars.forEach((car) -> car.move(randomNumberGenerator.generateRandomNumber()));
    }

    public List<String> getWinners() {
        Long maxValue = getMaxValue();
        return cars.stream()
                .filter((car) -> Objects.equals(car.getPosition(), maxValue))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Long getMaxValue() {
        return Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public List<String> getResult() {
        return cars.stream()
                .map(Car::getResult)
                .collect(Collectors.toList());
    }
}
