package racing.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> generateCarsByNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));
        return cars;
    }
}
