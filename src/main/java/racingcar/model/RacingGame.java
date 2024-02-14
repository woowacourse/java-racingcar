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

    public Cars findWinners() {
        int maxProgress = cars.stream()
                .map(Car::getProgress)
                .reduce(Integer::max)
                .orElse(0);

        return new Cars(cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .toList());
    }
}
