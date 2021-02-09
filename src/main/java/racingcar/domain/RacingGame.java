package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class RacingGame {

    private final Cars cars;
    private final int trial;
    private int currentTrial = 0;

    public RacingGame(final Cars cars, final int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void tryToMove() {
        cars.tryToMove();
        currentTrial++;
    }

    public List<String> getWinners() {
        final int maxPosition = cars.findMaxPosition();
        return cars.findCarNamesLocatedAt(maxPosition);
    }

    public boolean isFinished() {
        return currentTrial >= trial;
    }

    public Cars getCars() {
        return cars;
    }
}
