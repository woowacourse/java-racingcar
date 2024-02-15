package model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(String nameStr) {
        cars = new ArrayList<>();
        String[] names = nameStr.split(",");
        for (String name : names) {
            cars.add(new Car(new Name(name)));
        }
    }

}
