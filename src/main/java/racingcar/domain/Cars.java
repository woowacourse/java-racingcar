package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.service.Movement;
import racingcar.utils.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplication(final List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_CAR_NAMES);
        }
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.move()));
    }

    public List<CarDto> getCarInfos() {
        return cars.stream()
                .map(Car::info)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getFarthestCar() {
        return cars.stream()
                .filter(this::isHighest)
                .map(Car::info)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isHighest(final Car standardCar) {
        return cars.stream().allMatch(standardCar::isFartherThan);
    }
}
