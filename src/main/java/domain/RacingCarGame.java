package domain;

import dto.CarsStatus;
import dto.RaceResult;
import dto.Winners;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    /**
     * Move cars for $count times
     */
    public RaceResult race() {
        List<CarsStatus> results = new ArrayList<>();
        for (int i = 0; i < count.getValue(); i++) {
            results.add(cars.move(new RandomNumberGenerator()));
        }
        return new RaceResult(results);
    }

    public Winners getWinners() {
        return cars.judge();
    }
}
