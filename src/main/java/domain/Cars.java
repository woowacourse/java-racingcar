package domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> moveByRandomNumber(numberGenerator, car));
    }

    private void moveByRandomNumber(NumberGenerator numberGenerator, Car car) {
        if (numberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE) {
            car.move();
        }
    }
}
