package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars(CarsName carsName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carsName.getCarsName()) {
            cars.add(createCar(carName));
        }

        this.cars = cars;
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String toString() {
        String carsName = "[";

        for (int i = 0; i < cars.size() - 1; i++) {
            carsName += (cars.get(i).getName() + ", ");
        }

        carsName += (cars.get(cars.size() - 1).getName() + "]");

        return carsName;
    }
}