package domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    private static final String COMMA = ",";

    public static List<Car> create(String carsName) {
        String[] carNames = carsName.split(COMMA);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
