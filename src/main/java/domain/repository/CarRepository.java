package domain.repository;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> createCars(String[] names) {
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
