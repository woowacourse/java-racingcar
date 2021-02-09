package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int INIT_ROUND = 1;

    private final Cars cars;
    private final Round goalRound;
    private Round currentRound;

    public RacingGame(List<String> names, int goalRound) {
        this(Cars.createCarsByNames(names), goalRound);
    }

    public RacingGame(Cars cars, int goalRound) {
        this.cars = cars;
        this.goalRound = new Round(goalRound);
        this.currentRound = new Round(INIT_ROUND);
    }

    public void playRound() {
        cars.moveCars();
        this.currentRound = currentRound.nextRound();
    }

    public boolean isEnd() {
        return currentRound.isBiggerThan(goalRound);
    }

    public GameResult findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public Round getCurrentRound() {
        return currentRound;
    }
}
