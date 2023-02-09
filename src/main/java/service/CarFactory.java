package service;


import static utils.Constant.INIT_POSITION;

import domain.Car;
import domain.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarFactory {

    public static Map<Car, Integer> buildCars(List<String> carNames) {
        Map<Car, Integer> cars = new HashMap<>();
        for (String carName : carNames) {
            cars.put(new Car(new Name(carName)), INIT_POSITION);
        }
        return cars;
    }

}
