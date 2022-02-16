package racingcar.model;

import static racingcar.utils.validator.CarNamesValidator.*;
import static racingcar.utils.validator.TryCountValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RandomNumber;

public class RacingGame {

    private static final int GAME_END_COUNT = 0;

    private final List<Car> cars;
    private int tryCount;

    public RacingGame(String[] cars, String tryCount) {
        validateDuplicate(cars);
        this.cars = createCars(cars);

        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    private List<Car> createCars(final String[] carNames) {
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
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
