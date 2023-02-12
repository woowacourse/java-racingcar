package model.car;

import util.CarNameValidator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars){

    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
