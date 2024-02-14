package racingcar.model;

import java.util.stream.IntStream;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void move(RaceRule raceRule) {
        cars.stream()
                .filter(car -> raceRule.isGo())
                .forEach(Car::move);
    }
}
