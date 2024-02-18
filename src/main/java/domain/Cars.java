package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 20;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private static void validate(final List<Car> cars) {
        validateMinCarsSize(cars);
        validateMaxCarsSize(cars);
        validateDuplication(cars);
    }

    private static void validateMinCarsSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이 참가해야 합니다.", MIN_CARS_SIZE));
        }
    }

    private static void validateMaxCarsSize(final List<Car> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(String.format("참가 자동차는 %d대를 넘을 수 없습니다.", MAX_CARS_SIZE));
        }
    }

    private static void validateDuplication(final List<Car> cars) {
        Set<String> duplicatedName = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (duplicatedName.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있을 수 없습니다.");
        }
    }

    public void moveAll(final NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public int getCarPositionOf(int index) {
        return cars.get(index).getPosition();
    }

    public String getCarNameOf(int index) {
        return cars.get(index).getName();
    }

    public int getSize() {
        return cars.size();
    }
}
