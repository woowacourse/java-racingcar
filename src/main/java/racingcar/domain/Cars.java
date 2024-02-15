package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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

    public List<Car> determineWinner(List<Car> cars) {
        Car winnerCar = cars.stream().max(Comparator.comparing(Car::getCount)).get();
        for(Car car : cars) {

        }
    }
}
