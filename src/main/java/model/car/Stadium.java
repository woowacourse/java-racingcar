package model.car;

import model.manager.CarMoveManager;
import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Stadium {

    private final Cars cars;
    private final CarMoveManager carMoveManager;

    public Stadium(List<String> carNames, CarMoveManager carMoveManager) {
        this.cars = new Cars(createCars(carNames));
        this.carMoveManager = carMoveManager;
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCurrentResult() {
        return List.copyOf(cars.getCars());
    }

    public void moveAllCarsOnce() {
        cars.getCars()
                .forEach(car -> car.move(carMoveManager.isMove(RandomNumberGenerator.getRandomNumber())));
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.getCars()
                .stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return cars.getCars()
                .stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);
    }
}
