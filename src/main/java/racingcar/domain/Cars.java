package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(final String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }

    public void moveAllCars() {
        for(Car car: cars) {
            int randomNumber = RandomNumber.generate();
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
