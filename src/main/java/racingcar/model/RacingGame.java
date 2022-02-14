package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RandomNumber;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String[] cars, int tryCount) {
        this.cars = new ArrayList<>();
        createCars(cars);
        this.tryCount = tryCount;
    }

    private void createCars(final String[] carNames) {
        Arrays.stream(carNames)
            .forEach(carName -> cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void race() {
        cars.forEach(car -> car.move(RandomNumber.generate()));
    }

    public List<String> getWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition())
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}
