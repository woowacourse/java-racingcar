package racingcar.domain;

import racingcar.domain.Generator.CarMoveValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static List<Car> winners = new ArrayList<>();

    private List<Car> cars;
    private CarMoveValueGenerator carMoveValueGenerator = () -> (int)(Math.random() * RANDOM_LIMIT_VALUE);

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(name -> new Car(name, carMoveValueGenerator))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public void selectWinners() {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .get();
        winners = cars.stream()
                .filter(car -> car.isMaxPosition(maxDistanceCar))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}