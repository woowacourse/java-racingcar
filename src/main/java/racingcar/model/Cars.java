package racingcar.model;

import racingcar.controller.NumericGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private NumericGenerator generator;
    private List<Car> cars;

    public Cars(NumericGenerator generator, List<String> carNames) {
        this.generator = generator;

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            if (generator.generate() >= 4) {
                car.move();
            }
        }
    }

    public String calculateWinner() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
