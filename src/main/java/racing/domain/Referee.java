package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Referee {
    private final List<Car> cars;

    public Referee(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> judgeWinners() {
        List<Car> winners = new ArrayList<>();
        Car winner = findWinner(), curCar;
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            curCar = it.next();
            if (curCar.compareTo(winner) == 0) {
                winners.add(curCar);
            }
        }
        return winners;
    }

    private Car findWinner() {
        return Collections.max(cars);
    }

    public RaceResult getResult() {
        return new RaceResult(judgeWinners());
    }
}
