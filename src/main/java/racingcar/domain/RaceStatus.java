package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceStatus {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private final List<Car> cars;
    private final Movable strategy;

    public RaceStatus(Map<String, Integer> carInfo, Movable strategy) {
        cars = Collections.unmodifiableList(
            carInfo.entrySet().stream()
                .filter(x -> !x.getKey().trim().equals("") && !x.getKey().trim().equals(" "))
                .map(x -> new Car(x.getKey().trim(), x.getValue()))
                .collect(Collectors.toList())
        );
        if (cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        this.strategy = strategy;
    }


    public RaceStatus(List<String> names, Movable strategy) {
        this(
            new LinkedHashMap<String, Integer>() {{
                names.stream()
                    .map(x -> x.trim())
                    .filter(x -> !x.equals("") && !x.equals(" "))
                    .forEach(name -> put(name, 0));
            }},
            strategy
        );
    }

    public RaceStatus startEachRound() {
        cars.forEach(car -> car.move(strategy));
        return this;
    }

    public List<Car> getCurrentStatus() {
        return cars;
    }

    public List<String> getNameOfWinners() {
        Car oneOfTheWinners = Collections.max(cars);
        return cars.stream()
            .filter(x -> x.compareTo(oneOfTheWinners) == 0)
            .map(x -> x.toString())
            .collect(Collectors.toList());
    }
}