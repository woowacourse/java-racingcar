package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.engine.Engine;
import racingcar.domain.engine.RandomEngine;

public class RacingGame {

    private List<Car> cars;
    private int numOfRacingRound;

    public RacingGame(String[] carNames, int numOfRacingRound) {
        this.cars = prepareCars(carNames);
        this.numOfRacingRound = numOfRacingRound;
    }

    private List<Car> prepareCars(String[] carNames) {
        Engine engine = new RandomEngine();
        return Arrays.stream(carNames)
            .map(carName -> new Car(carName, engine))
            .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return numOfRacingRound == 0;
    }

    public void race() {
        racePerRound();
        numOfRacingRound--;
    }

    private void racePerRound() {
        cars.forEach(Car::run);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinners() {
        int max = findMaxMove();
        return cars.stream()
            .filter(car -> car.isOn(max))
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }

    private int findMaxMove() {
        List<Integer> traces = cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
        return traces.stream()
            .max(Integer::compare)
            .orElseThrow(() -> new RuntimeException("no Winner"));
    }
}