package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

import java.util.*;

public class RaceParticipants {
    private final List<Car> cars;

    public RaceParticipants(final List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicateNames(final List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_CAR_NAMES);
        }
    }

    public Map<String, Integer> move() {
        cars.forEach(Car::move);
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }
}
