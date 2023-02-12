package racingcar.domain;

import racingcar.dto.CarStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int MINIMUM_CARS_COUNT = 2;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateCarsCount(cars.size());
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<CarStatus> showRaceResult() {
        return cars.stream()
                .map(Car::checkCurrentStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> pickWinnerCarsName() {
        Car winner = pickMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Car pickMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("비교할 자동차가 없습니다."));
    }

    private static void validateCarsCount(int size) {
        if (size < MINIMUM_CARS_COUNT) {
            throw new IllegalArgumentException("자동차 수는 2대 이상이어야 합니다.");
        }
    }
}
