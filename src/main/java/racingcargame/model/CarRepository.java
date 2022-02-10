package racingcargame.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRepository {
    private List<Car> cars;

    public CarRepository(List<String> carNames) {
        cars = carNames.stream().
                map(carName -> new Car(carName, 0)).
                collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        cars.forEach(Car::moveCar);
    }
}
