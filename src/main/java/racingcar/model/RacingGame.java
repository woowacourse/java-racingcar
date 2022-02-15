package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class RacingGame {

    private final static int TRY_COUNT_END_NUMBER = 0;

    private final List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        cars = new ArrayList<>();
        createCars(carNames);

        this.tryCount = tryCount;
    }

    public void createCars(final String[] carNames) {
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));
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

    public List<Car> getCars() {
        return cars;
    }
}
