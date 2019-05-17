package domain;

import java.util.ArrayList;

public class CarFactory {
    public ArrayList<Car> newCars(String str) {
        String[] names = str.split(",");

        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.create(name));
        }
        return cars;
    }
}
