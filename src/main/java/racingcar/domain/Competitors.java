package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Competitors {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private final List<Car> cars;

    public Competitors(Map<String, Integer> carInfo) {
        cars = Collections.unmodifiableList(
            carInfo.entrySet().stream()
                .map(x -> new Car(x.getKey(), x.getValue()))
                .collect(Collectors.toList())
        );
        if (cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
    }

    public Competitors(List<String> names) {
        this(new LinkedHashMap<String, Integer>() {{
            names.forEach(name -> put(name.trim(), 0));
        }});
    }

    public List<Car> startEachRound(Movable strategy) {
        cars.forEach(car -> car.move(strategy));
        return cars;
    }

    public List<Car> getWinners() {
        Car oneOfTheWinners = Collections.max(cars);
        return cars.stream()
                .filter(x -> x.compareTo(oneOfTheWinners) == 0)
                .collect(Collectors.toList());
    }
}