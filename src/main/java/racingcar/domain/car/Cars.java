package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.movement.MovementStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String[] names) {
        return new Cars(createCars(names));
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(name -> new Car(name.trim()))
            .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        Car winnerCar = findWinner();
        return cars.stream()
            .filter(car -> car.isSamePosition(winnerCar))
            .collect(Collectors.toList());
    }

    private Car findWinner() {
        return cars.stream()
            .max(Car::selectWinner)
            .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }

    public void move(MovementStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
