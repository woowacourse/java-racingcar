package domain;

import static validation.ParticipantsValidator.PARTICIPANTS_VALIDATOR;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Car> cars;

    public Participants(List<String> carNames) {
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        PARTICIPANTS_VALIDATOR.validate(carNames);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }
}
