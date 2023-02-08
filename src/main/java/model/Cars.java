package model;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars (String carsName) {
        List<String> carNames = splitCarName(carsName);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(","));
    }
}
