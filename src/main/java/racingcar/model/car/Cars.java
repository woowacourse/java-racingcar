package racingcar.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String LINE_BREAK = "\n";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream()
                .filter(Car::movable)
                .forEach(Car::moveForward);
    }

    public String getCarsPositionFormat() {
        return cars.stream()
                .map(Car::getCurrentStateFormat)
                .collect(Collectors.joining(LINE_BREAK));
    }

    public List<Car> getWinnerCars() {
        int maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
