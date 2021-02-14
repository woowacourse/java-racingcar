package racingCar.domain;

import racingCar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private Round round;

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        cars.racePerRound();
        this.round = round.next();
    }

    public boolean isEnd() {
        return round.isFinish();
    }
}