package racingcar.domain;

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

    public RacingResult startRace(int numOfRound) {
        RacingResult racingResult = new RacingResult();
        cars.forEach(car -> racingResult.addParticipant(car));
        for (int i = 0; i < numOfRound; i++) {
            startRound(racingResult);
        }
        return racingResult;
    }

    void startRound(RacingResult racingResult) {
        for (Car car : cars) {
            racingResult.updateResult(car, car.move(strategy));
        }
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