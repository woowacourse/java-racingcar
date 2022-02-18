package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.domain.strategy.MoveStrategy;

public class UniqueCars implements Cars {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    private final Set<Car> cars;

    public UniqueCars(List<Car> cars) {
        this.cars = Set.copyOf(cars);
        validateDuplicatedCars(cars);
    }

    @Override
    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    @Override
    public Set<Car> getCars() {
        return cars;
    }

    @Override
    public Set<Car> getCarsInPosition(int position) {
        return cars.stream()
                .filter(car -> car.isPosition(position))
                .collect(Collectors.toSet());
    }

    @Override
    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void validateDuplicatedCars(List<Car> cars) {
        if (cars.size() != this.cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }
}
