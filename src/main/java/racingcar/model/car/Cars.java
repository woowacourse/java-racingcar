package racingcar.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String LINE_BREAK = "\n";
    private static final String CAR_SEPARATOR = ", ";

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

    public Cars getWinnerCars() {
        int maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return new Cars(cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList()));
    }

    public String getCarsWinnerFormat() {
        return cars.stream()
                .map(Car::getWinnerCarNameFormat)
                .collect(Collectors.joining(CAR_SEPARATOR));
    }
}
