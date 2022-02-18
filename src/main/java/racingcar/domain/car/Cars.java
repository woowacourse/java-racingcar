package racingcar.domain.car;

import racingcar.dto.CarDto;
import racingcar.domain.movement.Movement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_CAR_NAMES = "자동차 이름들 간 중복이 있습니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplication(final List<String> carNames) {
        Set<String> addedCarNames = new HashSet<>();
        carNames.forEach(carName -> checkCarNameDuplication(addedCarNames, carName));
    }

    private void checkCarNameDuplication(final Set<String> addedCarNames, final String nextCarName) {
        if (addedCarNames.contains(nextCarName)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
        }
        addedCarNames.add(nextCarName);
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.getMovementValue()));
    }

    public List<CarDto> getCarInfos() {
        return cars.stream()
                .map(Car::convertToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getFarthestCar() {
        final Car winnerCar = findWinnerCar();
        return cars.stream()
                .filter(other -> hasSameDistance(winnerCar, other))
                .map(Car::convertToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    private Car findWinnerCar() {
        return cars.stream()
                .sorted()
                .findFirst()
                .get();
    }

    private boolean hasSameDistance(final Car first, final Car second) {
        return first.compareTo(second) == 0;
    }
}
