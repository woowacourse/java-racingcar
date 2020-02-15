package racingcargame.controller;

import racingcargame.domain.Cars;

public class CarRace {
    private Cars cars;
    private TryNumber tryNumber;

    public CarRace(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void start() {
        while (tryNumber.isNotZero()) {
            cars.moveOneRound();
            tryNumber.reduce();
        };
    }
}
