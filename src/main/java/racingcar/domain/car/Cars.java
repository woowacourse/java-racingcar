package racingcar.domain.car;

import racingcar.dto.CarDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private static final String DUPLICATED_CAR_NAMES = "자동차 이름들 간 중복이 있습니다.";
    private static final String WINNER_CANNOT_FOUND_EXCEPTION_MESSAGE = "자동차들이 존재하지 않아 우승자를 판별할 수 없습니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplication(final List<String> carNames) {
        Set<String> addedCarNames = new HashSet<>();
        for (String carName : carNames) {
            checkCarNameDuplication(addedCarNames, carName);
            addedCarNames.add(carName);
        }
    }

    private void checkCarNameDuplication(final Set<String> addedCarNames, final String nextCarName) {
        if (addedCarNames.contains(nextCarName)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
        }
    }

    public void move(final List<Integer> movementValues) {
        IntStream.range(0, cars.size())
                .forEach(index -> cars.get(index).move(movementValues.get(index)));
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
                .orElseThrow(() -> new IllegalArgumentException(WINNER_CANNOT_FOUND_EXCEPTION_MESSAGE));
    }

    private boolean hasSameDistance(final Car first, final Car second) {
        return first.compareTo(second) == 0;
    }
}
