package domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import dto.CarNameRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MAX_CAR_COUNT = 50;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars fromEmpty() {
        return new Cars(List.of(Car.fromEmpty(), Car.fromEmpty()));
    }

    private void validate(List<Car> cars) {
        if (!(cars.size() >= MIN_CAR_COUNT && cars.size() <= MAX_CAR_COUNT)) {
            throw new IllegalArgumentException("정상적인 경주를 위해 자동차는 2대에서 50대 사이로 입력해주세요.");
        }
    }

    public void move(RandomMovementGenerator randomMovementGenerator) {
        cars.stream()
                .filter(car -> randomMovementGenerator.generate())
                .forEach(Car::move);
    }

    public List<Car> getMaxDistanceCars() {
        Car maxDistanceCar = getMaxDistanceCar(cars);
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistanceCar))
                .collect(toList());
    }

    private static Car getMaxDistanceCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최댓값 계산에 오류가 발생했습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }
}