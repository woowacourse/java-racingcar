package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.RandomNumberService;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = toCar(carNames);
    }

    private List<Car> toCar(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomNumberService.getRandomNumber()));
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
