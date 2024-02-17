package domain;

import domain.car.Car;
import domain.car.CarName;
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
            throw new IllegalArgumentException(String.format("경주에 참가하는 자동차는 %d 대 이상이어야 합니다.", MIN_CARS_SIZE));
        }
    }

    private static void validateMaxCarsSize(List<RandomMovingCar> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(String.format("경주에 참가하는 자동차는 %d 대 이하이어야 합니다.", MAX_CARS_SIZE));
        }
    }

    private static void validateDuplication(List<RandomMovingCar> cars) {
        Set<String> duplicatedName = cars.stream()
                .map(RandomMovingCar::getName)
                .collect(Collectors.toSet());

        if (duplicatedName.size() != cars.size()) {
            throw new IllegalArgumentException("경주에 중복된 이름의 자동차가 존재할 수 없습니다.");
        }
    }

    public void moveAll() {
        for (RandomMovingCar car : cars) {
            car.move();
        }
    }

    public List<RandomMovingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
