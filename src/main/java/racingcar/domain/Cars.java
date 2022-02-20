package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicatedCars(cars);
        this.cars = List.copyOf(cars);
    }

    public void moveCars(MovePredicate movePredicate) {
        cars.forEach(car -> car.move(movePredicate.testRandom()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> matchPosition(int position) {
        return cars.stream()
                .filter(car -> car.isPosition(position))
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void validateDuplicatedCars(List<Car> cars) {
        if (cars.size() != Set.copyOf(cars).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }
}
