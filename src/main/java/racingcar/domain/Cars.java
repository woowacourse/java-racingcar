package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(createCar(name.trim()));
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }
}
