package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private List<Car> cars;

    public Participants() {
        cars = new ArrayList<>();
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public void add(String name) {
        Car car = new Car(name);
        cars.add(car);
    }
}
