package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RaceReferee {
    private final List<Car> cars;

    public RaceReferee(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> judgeWinners() {
        List<Car> winners = cars;
        Car winner = findWinner(cars);
        winners.removeIf((c) -> (isSamePosition(c, winner)));
        return winners;
    }

    private boolean isSamePosition(Car car1, Car car2) {
        return car1.compareTo(car2) != 0;
    }

    private Car findWinner(List<Car> cars) {
        return Collections.max(cars);
    }

    public RaceResult getResult() {
        return new RaceResult(judgeWinners());
    }
}
