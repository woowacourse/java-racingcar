package racingcar.domain;

import racingcar.service.MoveOrStop;
import racingcar.utils.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int INITIAL_DISTANCE = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplication(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_CAR_NAMES);
        }
    }

    public void move(MoveOrStop moveOrStop) {
        cars.forEach(car -> car.move(moveOrStop.determine()));
    }

    public List<Car> getFarthestCars() {
        int maxDistance = cars.stream()
                .max(Car::orderByDistanceAsc)
                .map(Car::getDistance)
                .orElseThrow(IllegalArgumentException::new);

        List<Car> farthestCars = cars.stream()
                .filter(car -> car.isSameWith(maxDistance))
                .collect(Collectors.toUnmodifiableList());

        return farthestCars;
    }

}
