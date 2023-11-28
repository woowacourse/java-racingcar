package domain.core;

import domain.vo.Name;
import domain.vo.Record;
import domain.vo.TryCount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(NumberGenerator numberGenerator, List<String> carNames, int tryCount) {
        this.numberGenerator = numberGenerator;
        this.cars = toCars(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    private Cars toCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public List<List<Record>> playGame() {
        List<List<Record>> records = new ArrayList<>();

        for (int i = 0; i < tryCount.value(); i++) {
            List<Car> result = cars.playOnce(numberGenerator);
            List<Record> record = convertTo(result);
            records.add(record);
        }
        return records;
    }

    private List<Record> convertTo(List<Car> result) {
        return result.stream()
                .map(car -> new Record(car.name(), car.distance()))
                .collect(Collectors.toList());
    }

    public List<Car> winners() {
        return cars.winners();
    }
}
