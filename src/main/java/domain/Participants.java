package domain;

import static validation.ParticipantsValidator.PARTICIPANTS_VALIDATOR;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Car> cars;

    public Participants(List<String> carNames) {
        PARTICIPANTS_VALIDATOR.validate(carNames);
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public void add(List<String> carNames) {

    }

}
