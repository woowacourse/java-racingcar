package service;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> buildCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
