package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

public class RacingGame {

    private final static int TRY_COUNT_END_NUMBER = 0;
    private final static int FIRST_WINNER_INDEX = 0;
    private final static int EQUAL_CODE = 0;

    private final List<Car> cars;
    private int tryCount;

    public RacingGame(List<Car> cars) {
        this(cars, 0);
    }

    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public boolean isEnd() {
        return tryCount == TRY_COUNT_END_NUMBER;
    }

    public void race() {
        for (Car car : cars) {
            car.moveForward(RandomNumberGenerator.pickRandomNumber());
        }

        tryCount--;
    }

    public List<String> getWinners() {
        Collections.sort(cars);

        return cars.stream()
                .filter(car -> car.compareTo(cars.get(FIRST_WINNER_INDEX)) == EQUAL_CODE)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
