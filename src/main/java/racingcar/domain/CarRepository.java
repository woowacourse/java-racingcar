package racingcar.domain;

import racingcar.dto.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final int START_POINT = 0;
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        this.cars = createCarsByNames(carNames);
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
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
