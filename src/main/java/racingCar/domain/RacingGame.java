package racingCar.domain;

import racingCar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private Round round;

    public RacingGame(Cars cars, int round){
        this(cars,new Round(round));
    }

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        cars.racePerRound();
        this.round = round.goOn();
    }

    public boolean isEnd() {
        return round.isEnd();
    }
}