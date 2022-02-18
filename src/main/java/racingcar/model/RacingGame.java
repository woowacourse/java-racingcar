package racingcar.model;

public class RacingGame {
    private Cars cars;
    private int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void raceRound() {
        cars.moveRound();
    }
}
