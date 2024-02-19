package racingcar.model;

import racingcar.controller.NumericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MOVE_LINE = 4;

    private final NumericGenerator generator;
    private final List<Car> cars;

    public Cars(NumericGenerator generator, List<String> carNames) {
        this.generator = generator;

        this.cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public List<Car> move() {
        cars.forEach(car -> {
            if (generator.generate() >= MOVE_LINE) {
                car.move();
            }
        });

        return new ArrayList<>(cars);
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
