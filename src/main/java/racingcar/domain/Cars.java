package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String ERROR = "[ERROR] ";
    private static final String CAR_NAME_DUPLICATION_ERROR = ERROR + "자동차 이름은 중복되지 않게 입력해 주세요.";

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplication(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> nonDuplicatedNames = new HashSet<>(carNames);

        if (nonDuplicatedNames.size() != carNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR);
        }
    }

    public void decideMovableCar() {
        for (Car car : cars) {
            MovableImpl movable = new MovableImpl();

            car.move(movable);
        }
    }

    public List<String> extractNames() {
        List<String> names = new ArrayList<>();

        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    public List<Integer> extractPositions() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
