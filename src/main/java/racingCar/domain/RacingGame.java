package racingCar.domain;

import racingCar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private int numOfRacingRound;

    public RacingGame(Cars cars, int numOfRacingRound) {
        this.cars = cars;
        this.numOfRacingRound = numOfRacingRound;
    }

    public void race() {
        cars.racePerRound();
        numOfRacingRound--;
    }

    public boolean isEnd() {
        return numOfRacingRound == 0;
    }
}