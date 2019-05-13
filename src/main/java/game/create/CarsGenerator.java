package game.create;

import game.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        addCar(carNames, cars);
        return cars;
    }

    private static void addCar(String[] carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
