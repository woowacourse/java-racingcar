package racingcar.model;

import racingcar.view.OutputView;

public class RacingGame {

    private final Cars cars;
    private int tryCount;

    public RacingGame(final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void race() {
        while (!isEnd()) {
            raceRound();
            OutputView.printPosition(cars);
        }
    }

    private void raceRound() {
        cars.moveRound();
        this.tryCount--;
    }

    public boolean isEnd() {
        return tryCount == 0;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
