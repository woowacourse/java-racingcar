package racingcar.domain;

import racingcar.util.Validator;

import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> names) {
        Validator.validateCarNames(names);
        this.cars = names.stream().map(Car::new).toList();
    }

    public void moveAll(final MovementDecider movementDecider) {
        for(Car car: cars) {
            final int condition = movementDecider.generate();
            car.move(condition);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> determineWinner() {
        final Car winnerCar = cars.stream()
                .max(Comparator.comparing(Car::getMovement))
                .get();
        return cars.stream()
                .filter(car -> car.isSameMovement(winnerCar))
                .toList();
    }
}
