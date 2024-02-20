package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final int MAX_CARS_SIZE = 10;
    private final int MIN_CARS_SIZE = 2;
    private final int MAX_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNotDuplicate(cars);
        validateSize(cars);
        this.cars = cars;
    }

    private void validateNotDuplicate(final List<Car> cars) {
        long uniqueCarNames = cars.stream()
                .distinct()
                .count();
        if (cars.size() != uniqueCarNames) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("자동차 대수는 %d대 이상 %d대 이하여야 합니다.", MIN_CARS_SIZE, MAX_CARS_SIZE)
            );
        }
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate(MAX_RANDOM_NUMBER)));
    }

    public Map<String, Integer> result() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    public List<String> getWinners() {
        final Car highestPositionCar = getHighestPositionCar();
        return getSamePositionCars(highestPositionCar);
    }

    private Car getHighestPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("공백을 입력할 수 없습니다."));
    }

    private List<String> getSamePositionCars(final Car highestPositionCar) {
        return cars.stream()
                .filter(highestPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }
}
