package controller;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static List<Car> cars = new ArrayList<>();

    public static String[] nameSplit(String input) {
        return input.split(",");
    }

    public static List<Car> getCarList() {
        return cars;
    }

    public static void setCarList(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }


}
