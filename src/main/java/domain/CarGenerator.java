package domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
