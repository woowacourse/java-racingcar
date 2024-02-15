package model;

import static util.Util.*;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(generateRandomNumber());
        }
    }
}