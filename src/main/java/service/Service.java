package service;

import domain.Car;
import domain.Cars;
import dto.Result;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Service {
    public static final String DUPLICATING_NAME_EXCEPTION_MESSAGE = "중복된 이름은 사용할 수 없습니다.";
    private final Cars cars;

    public Service(Cars cars) {
        this.cars = cars;
    }

    public void initializeCars(List<String> names) {
        validateDuplication(names);
        for (String carName : names) {
            cars.saveCar(Car.of(carName));
        }
    }

    public void move() {
        cars.move();
    }

    public Result getResult() {
        return cars.getResult();
    }

    public List<String> getWinners() {
        return cars.getWinnerNames();
    }

    private void validateDuplication(List<String> names) {
        Set<String> namesWithoutDuplication = new HashSet<>(names);
        if (names.size() != namesWithoutDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATING_NAME_EXCEPTION_MESSAGE);
        }
    }
}
