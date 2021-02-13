package racingcar.domain;

import java.util.List;
import java.util.Map;

public class RacingCarGame {
    private final Cars cars;
    private final Lap lap;

    public RacingCarGame(Cars cars, Lap lap) {
        this.cars = cars;
        this.lap = lap;
    }

    public boolean isEnd() {
        return lap.isZero();
    }

    public void race() {
        cars.raceOneLap();
        lap.decrement();
    }

    public Map<String, Integer> getResult() {
        return cars.getStatus();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
