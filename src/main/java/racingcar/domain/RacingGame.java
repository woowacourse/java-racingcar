package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.engine.Engine;
import racingcar.domain.engine.RandomEngine;

public class RacingGame {

    private Cars cars;
    private int numOfRacingRound;

    public RacingGame(String[] carNames, int numOfRacingRound) {
        this.cars = prepareCars(carNames);
        this.numOfRacingRound = numOfRacingRound;
    }

    private Cars prepareCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
            .map(carName -> new Car(carName, new RandomEngine()))
            .collect(Collectors.toList()));
    }

    public boolean isEnd() {
        return numOfRacingRound == 0;
    }

    public void race() {
        racePerRound();
        numOfRacingRound--;
    }

    private void racePerRound() {
        cars.move();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public String getWinners() {
        return cars.getWinners();
    }
}