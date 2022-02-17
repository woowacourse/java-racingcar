package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import racingcar.util.BoundedRandomNumberGenerator;

public class ParticipatedCars {
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = 0;
    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public ParticipatedCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
    }

    public WinnerNames findWinners() {
        return getWinnerNamesWithFirstCar(findFastestCar());
    }

    private WinnerNames getWinnerNamesWithFirstCar(Car firstCar) {
        return WinnerNames.of(this, firstCar);
    }

    private Car findFastestCar() {
        Collections.sort(cars, Comparator.comparingInt(Car::getPosition));
        return cars.get(cars.size() - 1);
    }

    public void executeCarRacing() {
        for (Car car : cars) {
            car.tryToMoveBy(new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
