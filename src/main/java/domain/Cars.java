package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 20;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    // todo: 방어적 복사본
    public static Cars from(List<Car> cars) {
        validate(cars);
        return new Cars(cars);
    }

    private static void validate(List<Car> cars) {
        validateMinCarsSize(cars);
        validateMaxCarsSize(cars);
        validateDuplication(cars);
    }


    private static void validateMinCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상이 참가해야 합니다.");
        }
    }

    private static void validateMaxCarsSize(List<Car> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException("참가 자동차는 20대를 넘을 수 없습니다.");
        }
    }

    private static void validateDuplication(List<Car> cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            duplicatedName.add(car.getName());
        }
        if (duplicatedName.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있을 수 없습니다.");
        }
    }
}
