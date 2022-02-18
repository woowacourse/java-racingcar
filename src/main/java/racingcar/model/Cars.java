package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.utils.RandomGenerator;

public class Cars {
    private static final int MOVE_MIN_VALUE = 4;
    private static final int MAX_RANDOM_VALUE = 10;

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }

    public void race() {
        for (Car car : cars) {
            car.move(isMovable());
        }
    }

    private boolean isMovable() {
        int randomNumber = RandomGenerator.makeRandomNumberFromZeroToMax(MAX_RANDOM_VALUE);
        return randomNumber >= MOVE_MIN_VALUE;
    }

    public List<Name> judgeRacingWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량이 존재하지 않습니다"));
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsSize() {
        return this.cars.size();
    }
}
