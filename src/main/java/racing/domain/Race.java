package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> proceedRace() {
        List<String> result = new ArrayList<>();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.proceedRound();
            result.add(cars.toString());
        }
        return result;
    }

    public List<Car> getWinners() {
        return cars.findFurthestCars();
    }
}
