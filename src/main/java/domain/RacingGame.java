package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final Cars cars;

    public RacingGame(NumberGenerator numberGenerator, Cars cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public List<List<Record>> playGame(TryCount tryCount) {
        List<List<Record>> records = new ArrayList<>();
        for (int i = 0; i < tryCount.value(); i++) {
            List<Car> result = cars.playOnce(numberGenerator);
            List<Record> record = result.stream()
                    .map(car -> new Record(car.name(), car.distance()))
                    .collect(Collectors.toList());
            records.add(record);
        }
        return records;
    }

    public List<Car> winners() {
        return cars.winners();
    }
}
