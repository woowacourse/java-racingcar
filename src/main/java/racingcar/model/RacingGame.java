package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private int tryCount;

    public RacingGame(final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<GameResult> race() {
        List<GameResult> gameResults = new ArrayList<>();
        while (!isEnd()) {
            gameResults.add(raceRound());
        }
        return gameResults;
    }

    private GameResult raceRound() {
        cars.moveRound();
        this.tryCount--;
        return new GameResult(cars.getPositionResult());
    }

    private boolean isEnd() {
        return tryCount == 0;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
