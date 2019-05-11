package racinggame;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public List<Car> createCars(String[] carsName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carsName) {
            cars.add(createCar(carName));
        }

        return cars;
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

}