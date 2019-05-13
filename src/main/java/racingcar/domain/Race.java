package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int MIN_NUM_OF_CARS = 2;
    private final MovementStrategy strategy;
    private final List<Car> cars;

    public Race(List<String> names) {
        this(names, new RandomMovement());
    }

    public Race(List<String> names, MovementStrategy strategy) {
        this.cars = Collections.unmodifiableList(
                names.stream().map(name -> new Car(name)).collect(Collectors.toList())
        );
        validateCars();
        this.strategy = strategy;
    }

    private void validateCars() {
        if ((cars.size() < MIN_NUM_OF_CARS)
                || (cars.size() != new HashSet<>(cars).size())) {
            throw new IllegalArgumentException();
        }
    }

    public List<RoundResult> startRace(int numOfRound) {
        List<RoundResult> racingResult = new ArrayList<>();
        for (int i = 0; i < numOfRound; i++) {
            racingResult.add(startRound());
        }
        return racingResult;
    }

    private RoundResult startRound() {
        RoundResult roundResult;
        cars.forEach(car -> car.run(strategy));
        roundResult = new RoundResult(cars);
        return roundResult;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Race) obj).cars.equals(this.cars);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cars == null) ? 0 : cars.hashCode());
        result = prime * result + strategy.hashCode();
        return result;
    }
}