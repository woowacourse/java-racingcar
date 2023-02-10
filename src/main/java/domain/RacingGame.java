package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MOVABLE_BOUND = 4;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;


    public RacingGame(List<String> splitCarNames, NumberGenerator numberGenerator) {
        cars = splitCarNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.numberGenerator = numberGenerator;
    }

    public void start() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = numberGenerator.makeDigit();
        if (randomNumber >= MOVABLE_BOUND) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public List<Car> getWinners() {
        Car furthestCar = getFurthestCar();

        return cars.stream()
                .filter(car -> car.getPosition() == furthestCar.getPosition())
                .collect(Collectors.toList());
    }

    private Car getFurthestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get();
    }
}
