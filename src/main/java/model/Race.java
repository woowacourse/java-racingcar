package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Race {
    private static final String NOT_ENOUGH_CARS_ERROR_MESSAGE = "레이스에 참여하는 자동차는 최소 2대 이상이어야 합니다.";
    private static final String CAR_NAME_DUPLICATED_ERROR_MESSAGE = "중복된 이름의 자동차는 사용할 수 없습니다.";
    private static final int MIN_NUMBER_OF_CARS = 2;

    private final List<Car> cars;

    public Race(List<String> carNames) {
        cars = new ArrayList<>();
        validate(carNames);

        for (String carName : carNames) {
            cars.add(new Car(new Name(carName)));
        }
    }

    private void validate(List<String> carNames) {
        validateDuplicatedCarName(carNames);
        validateMinimumNumberOfCars(carNames);
    }

    private void validateDuplicatedCarName(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private void validateMinimumNumberOfCars(List<String> carNames) {
        if (carNames.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS_ERROR_MESSAGE);
        }
    }

    public void start() {
        for (Car car : cars) {
            int randomNumber = new Random().nextInt(10);
            car.move(randomNumber);
        }
    }

    public List<String> selectWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);

        return cars.stream()
                .filter(car -> car.isDistanceAt(winner.getDistance()))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
