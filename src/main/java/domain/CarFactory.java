package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> generateCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
