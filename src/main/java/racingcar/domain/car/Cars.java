package racingcar.domain.car;

import racingcar.dto.CarDto;
import racingcar.service.Movement;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_CAR_NAMES = "자동차 이름들 간 중복이 있습니다.";

    private final List<Car> values;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.values = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplication(final List<String> carNames) {
        int numOfDuplicationRemovedCars = (int) carNames.stream()
                .distinct()
                .count();
        if (numOfDuplicationRemovedCars != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
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
