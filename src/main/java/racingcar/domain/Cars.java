package racingcar.domain;

import java.util.List;
import racingcar.service.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateNotDuplicate(carNames);
        validateSize(carNames);
        this.cars = createCars(carNames);

    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateNotDuplicate(final List<String> carNames) {
        long uniqueCarNames = carNames.stream()
                .distinct()
                .count();
        if (carNames.size() != uniqueCarNames) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateSize(final List<String> carNames) {
        if (carNames.size() < 2 || carNames.size() > 10) {
            throw new IllegalArgumentException("자동차 대수는 2대 이상 10대 이하여야 합니다.");
        }
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generateRandomNumber(9)));
    }

    public List<String> result() {
        return cars.stream()
                .map(Car::result)
                .toList();
    }
}