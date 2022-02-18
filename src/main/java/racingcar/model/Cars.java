package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(toCar(carNames));
    }

    private static List<Car> toCar(List<String> carNames) {
        MovingCarStrategy movingCarStrategy = new RandomMovingStrategy();
        return carNames.stream()
                .map(carName -> new Car(carName, movingCarStrategy))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<String> getPosition() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public List<String> findWinnerCars() {
        Car maxPositionCar = findWinnerCar();
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Car findWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }
}
