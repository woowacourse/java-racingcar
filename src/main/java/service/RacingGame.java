package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private List<Car> cars;


    public RacingGame() {
        this.cars = new ArrayList<>();
    }

    public void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
