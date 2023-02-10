package racingcar.domain.carrepository;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRepository {
    private static final int MIN_NUMBER_OF_CARS = 2
    private static final int MOVING_CONDITION = 4;

    private final List<Car> repository;

    public CarRepository(List<Car> repository) {
        validate(repository);
        this.repository = repository;
    }

    private void validate(List<Car> repository) {
        if (isOutOfCarNumber(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
        }
        if (hasDuplication(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isOutOfCarNumber(List<Car> repository) {
        return repository.size() < MIN_NUMBER_OF_CARS;
    }

    private boolean hasDuplication(List<Car> repository) {
        return repository.stream()
                .distinct()
                .count() != repository.size();
    }

    public Map<String, Integer> moveCars() {
        NumberGenerator numberGenerator = new NumberGenerator();
        return repository.stream()
                .map(car -> decideMoveOrStay(car, numberGenerator.generateRandomNumber()))
                .collect(Collectors.toMap(Car::getName,
                        Car::getPosition,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    private Car decideMoveOrStay(Car car, int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
            car.move();
        }
        return car;
    }

    public List<Car> getRepository() {
        return repository;
    }

    public List<String> findWinner() {
        int maxPosition = repository.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoClassDefFoundError::new);

        return repository.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
