package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class RacingGame {
    private final Cars cars;
    private int moveCount;

    public RacingGame(Cars cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void race() {
        cars.move();
        moveCount--;
    }

    public boolean isEnd() {
        return moveCount <= 0;
    }

    public Cars getCars() {
        return cars;
    }
}
