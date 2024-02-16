package domain;

import domain.car.Car;
import domain.car.CarPosition;

import java.util.*;
import java.util.stream.Collectors;

public class RandomMovingCars {
    private static final CarPosition INITIAL_POSITION = new CarPosition(0);
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 20;

    private final List<RandomMovingCar> cars;

    public RandomMovingCars(List<RandomMovingCar> cars) {
        validate(cars);
        this.cars = cars;
    }

    private static void validate(List<RandomMovingCar> cars) {
        validateMinCarsSize(cars);
        validateMaxCarsSize(cars);
        validateDuplication(cars);
    }


    private static void validateMinCarsSize(List<RandomMovingCar> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상이 참가해야 합니다.");
        }
    }

    private static void validateMaxCarsSize(List<RandomMovingCar> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException("참가 자동차는 20대를 넘을 수 없습니다.");
        }
    }

    private static void validateDuplication(List<RandomMovingCar> cars) {
        Set<String> duplicatedName = cars.stream()
                .map(RandomMovingCar::getName)
                .collect(Collectors.toSet());

        if (duplicatedName.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있을 수 없습니다.");
        }
    }

    public void moveAll() {
        cars.forEach(RandomMovingCar::move);
    }

    public List<RandomMovingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
