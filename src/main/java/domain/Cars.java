package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 20;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

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
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이 참가해야 합니다.", MIN_CARS_SIZE));
        }
    }

    private static void validateMaxCarsSize(List<Car> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(String.format("참가 자동차는 %d대를 넘을 수 없습니다.", MAX_CARS_SIZE));
        }
    }

    private static void validateDuplication(List<Car> cars) {
        Set<String> duplicatedName = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (duplicatedName.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있을 수 없습니다.");
        }
    }

    public void moveAll(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
