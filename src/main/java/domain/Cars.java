package domain;

import dto.Result;
import utils.RandomNumberGenerator;

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

    public void move() {
        cars.forEach((car) -> car.move(randomNumberGenerator.generateRandomNumber()));
    }

    public List<String> getWinnerNames() {
        Long highestPosition = calculateHighestPosition();
        return cars.stream()
                .filter(car -> hasHighestPosition(highestPosition, car))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private static boolean hasHighestPosition(Long highestPosition, Car car) {
        return car.hasPosition(highestPosition);
    }

    private Long calculateHighestPosition() {
        return Collections.max(cars.stream()
                        .map((Car::getPosition))
                        .collect(Collectors.toUnmodifiableList()));
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
