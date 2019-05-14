package racingcar.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race implements Iterator {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private final List<Car> cars;
    private final Movable strategy = new RandomMovement();
    private int leftRounds;

    public Race(Map<String, Integer> carInfo, int numberOfTrials) {
        cars = Collections.unmodifiableList(
                carInfo.entrySet().stream()
                        .filter(x -> !x.getKey().trim().equals("") && !x.getKey().trim().equals(" "))
                        .map(x -> new Car(x.getKey().trim(), x.getValue()))
                        .collect(Collectors.toList())
        );
        if (cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        leftRounds = numberOfTrials;
    }

    public Race(List<String> names, int numberOfTrials) {
        this(
                new LinkedHashMap<String, Integer>() {{
                    names.stream()
                        .map(x -> x.trim())
                        .filter(x -> !x.equals("") && !x.equals(" "))
                        .forEach(name -> put(name, 0));
                }},
                numberOfTrials
        );
    }

    @Override
    public RaceResult next() {
        cars.forEach(car -> car.move(strategy));
        leftRounds--;
        return new RaceResult(cars);
    }

    public RaceResult finish() {
        return new RaceResult(cars).getWinners();
    }

    @Override
    public boolean hasNext() {
        return leftRounds != 0;
    }
}