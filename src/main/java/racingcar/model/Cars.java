package racingcar.model;

import racingcar.constants.Constants;
import racingcar.controller.NumericGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final NumericGenerator generator;
    private final List<Car> cars;

    public Cars(NumericGenerator generator, List<String> carNames) {
        this.generator = generator;

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> generator.generate() >= Constants.MOVE_LINE)
                .forEach(Car::move);
    }

    public List<String> calculateWinner() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
