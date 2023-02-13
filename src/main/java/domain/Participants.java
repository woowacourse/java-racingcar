package domain;

import static validation.ParticipantsValidator.PARTICIPANTS_VALIDATOR;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Car> cars;

    public Participants(List<String> carNames) {
        cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        PARTICIPANTS_VALIDATOR.validate(carNames);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void drive() {
        cars.forEach(Car::drive);
    }

    public List<Car> findWinners() {
        int maxDistance = cars.stream()
            .map(Car::getDrivenDistance)
            .max(Comparator.naturalOrder())
            .orElse(0);
        return cars.stream()
            .filter(car -> car.getDrivenDistance() == maxDistance)
            .collect(Collectors.toUnmodifiableList());
    }
}
