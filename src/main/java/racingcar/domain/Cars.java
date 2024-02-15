package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> names) {
        this.cars = names.stream().map(Car::new).toList();
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

    public List<Car> determineWinner() {
        Car winnerCar = cars.stream()
                .max(Comparator.comparing(Car::getCount))
                .get();
        return cars.stream()
                .filter(car -> car.isAlsoWinner(winnerCar))
                .toList();
    }
}
