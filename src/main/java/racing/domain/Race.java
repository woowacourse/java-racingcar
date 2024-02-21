package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racing.util.RandomMoveMaker;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;
    private final RandomMoveMaker randomMoveMaker;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.randomMoveMaker = new RandomMoveMaker(new Random());
    }

    public List<Cars> proceed() {
        List<Cars> result = new ArrayList<>();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.moveAll(randomMoveMaker);
            result.add(cars);
        }
        return result;
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
