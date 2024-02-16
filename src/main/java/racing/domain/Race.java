package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.util.NumberGenerator;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;
    private final NumberGenerator numberGenerator;

    public Race(Cars cars, TryCount tryCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    public List<String> proceed() {
        List<String> result = new ArrayList<>();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.moveAll(numberGenerator);
            result.add(cars.toString());
        }
        return result;
    }

    public List<Car> getWinners() {
        return cars.findFurthestCars();
    }
}
