package validator;

import racingcar.Car;

import java.util.List;

public class CarRepositoryValidator {

    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private static final int MAXIMUM_NUMBER_OF_CARS = 10;

    public static void validate(List<Car> newCars) {
        validateLessThanMinimumNumberOfCars(newCars);
        validateMoreThanMaximumNumberOfCars(newCars);
        validateDuplicatedCarNames(newCars);
    }

    private static void validateLessThanMinimumNumberOfCars(List<Car> newCars) {
        if (newCars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("게임 가능한 차는 차가 두 대 이상이어야 합니다.");
        }
    }

    private static void validateMoreThanMaximumNumberOfCars(List<Car> newCars) {
        if (newCars.size() < MAXIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("게임 가능한 차는 열 대 이하여야 합니다.");
        }
    }

    private static int numberOfDeleteDuplicatedCars(List<Car> newCars) {
        return (int) newCars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    private static void validateDuplicatedCarNames(List<Car> newCars) {
        if (numberOfDeleteDuplicatedCars(newCars) != newCars.size()) {
            throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
        }
    }
}