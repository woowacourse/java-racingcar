package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.util.RandomMoveStrategy;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;
    private final RandomMoveStrategy randomMoveStrategy;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.randomMoveStrategy = new RandomMoveStrategy();
    }

    public List<Cars> proceed() {
        List<Cars> result = new ArrayList<>();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.moveAll(randomMoveStrategy);
            result.add(cars);
        }
        return result;
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
