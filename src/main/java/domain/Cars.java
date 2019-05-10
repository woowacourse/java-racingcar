package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<String> carNames;

    public Cars(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<Car> setCarsOnRace() {
        try {
            return createCars();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarsOnRace();
        }
    }

    private List<Car> createCars() {
        Util.checkCarNameZeroSize(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            if(cars.contains(car)){
                throw new IllegalArgumentException("EX_NAME_DUPLE");
            }
            cars.add(car);
        }
        return cars;
    }
}
