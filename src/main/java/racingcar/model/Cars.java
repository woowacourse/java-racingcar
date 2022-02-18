package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void insertCar(final Car car) {
        cars.add(car);
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move(new RandomNumberGenerator());
        }
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}
