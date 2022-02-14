package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_POSITION = 0;
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name, START_POSITION)));
    }

    void moveCars() {
        cars.forEach(Car::moveCar);
    }

    public List<Car> getCars() {
        return cars;
    }
}
