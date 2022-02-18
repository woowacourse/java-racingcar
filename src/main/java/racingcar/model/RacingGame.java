package racingcar.model;

import static racingcar.utils.validator.TryCountValidator.validateTryCount;

import java.util.List;

public class RacingGame {

    private static final int GAME_END_COUNT = 0;

    private final Cars cars;
    private int tryCount;

    public RacingGame(String[] carNames, String tryCount) {
        cars = new Cars(carNames);
        this.tryCount = validateTryCount(tryCount);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public boolean isEnd() {
        return tryCount == GAME_END_COUNT;
    }

    public void race() {
        cars.move();
        tryCount--;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
