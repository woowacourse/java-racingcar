package racingcar.domain.car;

import racingcar.domain.car.util.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String ERROR_EXIST_DUPLICATED_CAR_NAMES_MESSAGE = "[ERROR] 중복되는 자동차이름이 존재합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_EXIST_DUPLICATED_CAR_NAMES_MESSAGE);
        }
    }

    public Cars play(MovingStrategy movingStrategy) {
        List<Car> cars = this.cars.stream()
                .map(car -> car.move(movingStrategy))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public int extractMaxPosition() {

        return cars.stream()
                .mapToInt(Car::toIntPosition)
                .max()
                .orElse(0);
    }

    public List<Car> extractSamePosition(int maxPosition) {

        return cars.stream()
                .filter(car -> car.equalToPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}