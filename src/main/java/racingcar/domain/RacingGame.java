package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Trial trial;

    public RacingGame(final Cars cars, final Trial trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void tryToMove() {
        cars.tryToMove();
        trial.moveToNextTrial();
    }

    public List<String> getWinners() {
        final int positionMax = cars.findPositionMax();
        return cars.findCarNamesLocatedAt(positionMax);
    }

    public boolean isFinished() {
        return trial.isFinished();
    }

    public Cars getCars() {
        return cars;
    }
}
