package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.service.Movement;
import racingcar.utils.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.values = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplication(final List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_CAR_NAMES);
        }
    }

    public void move(final Movement movement) {
        values.forEach(car -> car.move(movement.move()));
    }

    public List<CarDto> getCarInfos() {
        return values.stream()
                .map(Car::info)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getFarthestCar() {
        return values.stream()
                .filter(this::isHighest)
                .map(Car::info)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isHighest(final Car standardCar) {
        return values.stream().allMatch(standardCar::isFartherThan);
    }
}
