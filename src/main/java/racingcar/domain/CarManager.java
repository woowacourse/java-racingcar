package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarManager {
    private static final int MAX_MOVEMENT_VALUE = 9;

    private final List<Car> cars;

    public CarManager(final List<Car> cars) {
        this.cars = cars;
    }

    private Predicate<Car> isWinCar(final Car winnerCar) {
        return car -> car.isSamePosition(winnerCar);
    }

    public void moveCarsRandomly() {
        this.cars.forEach(car -> car.move(makeRandomCarMove()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(isWinCar(getWinnerCar()))
                .collect(Collectors.toList());
    }

    private Car getWinnerCar() {
        return Collections.max(cars);
    }

    private CarMovement makeRandomCarMove() {
        return new CarMovement(getRandomMovementValue());
    }

    private int getRandomMovementValue() {
        final Random random = new Random();
        return random.nextInt(MAX_MOVEMENT_VALUE);
    }
}
