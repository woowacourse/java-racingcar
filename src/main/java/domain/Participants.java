package domain;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Car> cars;

    public Participants() {
        cars = new ArrayList<>();
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public void add(List<String> carNames) {
        CAR_NAME_VALIDATOR.validate(carNames);
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

}
