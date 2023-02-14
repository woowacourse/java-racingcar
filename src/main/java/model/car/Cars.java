package model.car;

import model.manager.CarMoveManager;
import util.CarNameValidator;
import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        CarNameValidator.validate(carNames);
    }

    public List<Car> getCurrentResult() {
        return List.copyOf(cars);
    }

    public void moveAllCarsOnce(CarMoveManager carMoveManager) {
        cars.forEach(car -> car.move(carMoveManager.isMove(RandomNumberGenerator.getRandomNumber())));
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSame(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
