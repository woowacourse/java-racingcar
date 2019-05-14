package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceResult {
    Map<String, Integer> cars;

    public RaceResult(List<Car> cars) {
        this.cars = Collections.unmodifiableMap(
            new LinkedHashMap<String, Integer>() {{
                cars.forEach(car -> put(car.toString(), car.getPosition()));
            }}
        );
    }

    public Map<String, Integer> getResult() {
        return cars;
    }

    public RaceResult getWinners() {
        int positionOfWinners = Collections.max(cars.values());
        cars = Collections.unmodifiableMap(
            new LinkedHashMap<String, Integer>() {{
                cars.entrySet().stream()
                    .filter(x -> x.getValue() == positionOfWinners)
                    .forEach(x -> put(x.getKey(), x.getValue()));
            }}
        );
        return this;
    }
}