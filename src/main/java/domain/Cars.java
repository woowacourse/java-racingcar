package domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;

public class Cars {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MAX_CAR_COUNT = 50;
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validate(List<Car> cars) {
        if (!isValidCount(cars)) {
            throw new IllegalArgumentException("정상적인 경주를 위해 자동차는 2대에서 50대 사이로 입력해주세요.");
        }
    }

    private boolean isValidCount(List<Car> cars) {
        return cars.size() >= MIN_CAR_COUNT && cars.size() <= MAX_CAR_COUNT;
    }

    public void move(MovementGenerator randomMovementGenerator) {
        cars.stream()
                .filter(car -> checkMovable(randomMovementGenerator))
                .forEach(Car::move);
    }

    private boolean checkMovable(MovementGenerator randomMovementGenerator) {
        Movement movement = randomMovementGenerator.generate();
        return movement.isMovable();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}