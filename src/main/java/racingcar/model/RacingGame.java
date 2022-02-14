package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RandomNumber;

public class RacingGame {

    public static final int GAME_END_COUNT = 0;
    private final List<Car> cars;
    private int tryCount;

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

    public boolean isEnd() {
        if (tryCount > GAME_END_COUNT) {
            tryCount--;
            return false;
        }
        return true;
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
