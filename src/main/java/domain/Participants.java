package domain;

import static validation.ParticipantsValidator.PARTICIPANTS_VALIDATOR;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    public static final Comparator<Integer> MAX = Integer::max;
    private final List<Car> cars;

    public Participants(List<String> carNames, Judge judge) {
        cars = carNames.stream()
            .map(carName -> new Car(carName, judge))
            .collect(Collectors.toList());
        PARTICIPANTS_VALIDATOR.validate(carNames);
    }
    
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void drive() {
        cars.forEach(Car::drive);
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream()
            .map(Car::getDrivenDistance)
            .max(MAX)
            .orElse(0);
        return cars.stream()
            .filter(car -> car.getDrivenDistance() == maxDistance)
            .collect(Collectors.toUnmodifiableList());
    }
}
