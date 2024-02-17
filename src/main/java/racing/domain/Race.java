package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.util.RandomNumberGenerator;

public class Race {

    private static final int NUMBER_GENERATOR_BOUND = 10;
    private static final int NUMBER_GENERATOR_START = 0;

    private final Cars cars;
    private final TryCount tryCount;
    private final RandomNumberGenerator randomNumberGenerator;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.randomNumberGenerator = new RandomNumberGenerator(NUMBER_GENERATOR_BOUND, NUMBER_GENERATOR_START);
    }

    public List<Cars> proceed() {
        List<Cars> result = new ArrayList<>();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.moveAll(randomNumberGenerator);
            result.add(cars);
        }
        return result;
    }

    public List<Car> findWinners() {
        return cars.findFurthestCars();
    }
}
