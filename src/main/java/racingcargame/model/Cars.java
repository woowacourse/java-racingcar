package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(carName -> new Car(carName, START_POSITION))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    void moveCars() {
        cars.forEach(Car::moveCar);
    }
}
