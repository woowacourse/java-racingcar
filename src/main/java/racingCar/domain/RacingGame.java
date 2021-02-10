package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.car.Car;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.Engine;
import racingCar.domain.car.Engine.RandomEngine;

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