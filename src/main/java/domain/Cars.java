package domain;

import utils.RandomNumberGenerator;
import vo.Name;
import vo.Position;
import dto.Result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void saveCar(Car car) {
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
                .filter(car -> hasHighestPosition(highestPosition, car))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static boolean hasHighestPosition(Position highestPosition, Car car) {
        return car.hasPosition(highestPosition);
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
