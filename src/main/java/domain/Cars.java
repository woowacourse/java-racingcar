package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final Map<Car, Long> cars = new HashMap<>();

    public void add(Car car) {
        cars.put(car, 0L);
    }

    public Long getStatus(Car car) {
        return cars.get(car);
    }

    public void move(Car car) {
        cars.put(car, cars.get(car) + 1);
    }

    public List<Car> getWinners() {
        Long maxValue = getMaxValue();
        return cars.keySet().stream()
                .filter((car) -> cars.get(car) == maxValue)
                .collect(Collectors.toList());
    }

    private Long getMaxValue() {
        return Collections.max(cars.values());
    }
}
