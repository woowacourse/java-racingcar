package racingcar.domain.cars;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private static final int MOVING_CONDITION = 4;
    private final List<Car> repository;

    public Cars(List<Car> repository) {
        validate(repository);
        this.repository = repository;
    }

    private void validate(List<Car> repository) {
        if (isOutOfSize(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
        }
        if (hasDuplication(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isOutOfSize(List<Car> repository) {
        return repository.size() < 2;
    }

    private boolean hasDuplication(List<Car> repository) {
        return repository.stream()
                .distinct()
                .count() != repository.size();
    }

    public Map<String, Integer> movePosition() {
        NumberGenerator numberGenerator = new NumberGenerator();
        return repository.stream()
                .map(car -> moveByNumber(car, numberGenerator.generateRandomNumber()))
                .collect(Collectors.toMap(Car::getName,
                        Car::getPosition,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    private Car moveByNumber(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.updatePosition();
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
