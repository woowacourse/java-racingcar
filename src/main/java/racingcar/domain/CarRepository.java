package racingcar.domain;

import racingcar.constant.ErrorConstant;
import racingcar.dto.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final int START_POINT = 0;
    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        validateDuplicatedNames(carNames);
        validateCarCount(carNames.size());
        this.cars = createCarsByNames(carNames);
    }

    private void validateCarCount(int size) {
        if (size < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 수는 2대 이상이어야 합니다.");
        }
    }

    private List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, START_POINT))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarStatus> moveCars(NumberGenerator numberGenerator) {
        return cars.stream()
                .map(car -> car.move(numberGenerator))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarStatus> getFinalPosition() {
        return cars.stream()
                .map(Car::getCarStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerCarsName() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Car getWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "비교할 자동차가 없습니다."));
    }

    private void validateDuplicatedNames(List<String> carNames) {
        List<String> distinctCarNames = carNames.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        if (distinctCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 이름이 중복됩니다.");
        }
    }
}
