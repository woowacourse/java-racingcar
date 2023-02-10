package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import utils.RandomNumberGenerator;
import vo.Name;
import vo.Position;
import vo.Result;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public Position getPosition(Car car) {
        return car.getPosition();
    }

    public void move() {
        cars.forEach((car) -> car.move(randomNumberGenerator.generateRandomNumber()));
    }

    public List<Name> getWinners() {
        Position highestPosition = calculateHighestPosition();
        return cars.stream()
                .filter((car) -> Objects.equals(car.getPosition(), highestPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Position calculateHighestPosition() {
        return Collections.max(cars.stream()
                        .map((Car::getPosition))
                        .collect(Collectors.toList()));
    }

    public Result getResult() {
        return Result.of(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                ", randomNumberGenerator=" + randomNumberGenerator +
                '}';
    }
}
