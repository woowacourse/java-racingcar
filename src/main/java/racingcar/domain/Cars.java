package racingcar.domain;

import racingcar.constant.ErrorConstant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_CAR_COUNT = 2;

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplicatedNames(carNames);
        validateCarCount(carNames.size());
        this.cars = createCarsByNames(carNames);
    }

    public void moveCars(final NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getLatestResult() {
        return Collections.unmodifiableList(cars);
    }

    private void validateDuplicatedNames(final List<String> carNames) {
        List<String> distinctCarNames = carNames.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());

        if (distinctCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 이름이 중복됩니다.");
        }
    }

    private void validateCarCount(final int size) {
        if (size < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 수는 2대 이상이어야 합니다.");
        }
    }

    private List<Car> createCarsByNames(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
