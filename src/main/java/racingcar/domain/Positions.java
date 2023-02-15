package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Positions {
    public static final int MIN = 0;
    private static final int GO = 4;
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;
    private final RandomNumberPicker randomNumberPicker;

    public Positions(String carNames, RandomNumberPicker randomNumberPicker) {
        cars = Arrays.stream(carNames.split(NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());

        this.randomNumberPicker = randomNumberPicker;
    }

    public void moveCars() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        int number = randomNumberPicker.pickNumber();
        if (number >= GO) {
            car.move();
        }
    }

    public List<String> findWinner() {
        int max = findMax();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMax() {
        int max = MIN;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
