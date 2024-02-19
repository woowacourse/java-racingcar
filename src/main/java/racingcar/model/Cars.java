package racingcar.model;

import racingcar.controller.NumericGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final NumericGenerator generator;
    private final List<Car> cars;

    public Cars(NumericGenerator generator, List<String> carNames) {
        this.generator = generator;

        this.cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move(generator.generate()));
    }

    public List<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
