package racingcar.domain.car;

import racingcar.dto.CarDto;
import racingcar.service.Movement;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_CAR_NAMES = "자동차 이름들 간 중복이 있습니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
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
        cars.forEach(car -> car.move(movement.move()));
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
