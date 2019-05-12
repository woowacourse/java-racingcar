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
    private RoundResult roundResult = new RoundResult();
    private boolean checkRaceSucceed = false;

    public Race(List<String> names) {
        this(names, new RandomMovement());
    }

    public Race(List<String> names, MovementStrategy strategy) {
        validateNames(names);
        this.cars = Collections.unmodifiableList(
                names.stream().map(name -> new Car(name)).collect(Collectors.toList())
        );
        this.strategy = strategy;
        cars.forEach(car -> roundResult.addParticipant(car));
    }

    private void validateNames(List<String> names) {
        if ((names.size() < MIN_NUM_OF_CARS)
                || (names.size() != new HashSet<>(names).size())) {
            throw new IllegalArgumentException();
        }
    }

    public RoundResult startRound() {
        for (Car car : cars) {
            if (car.move(strategy)) {
                checkRaceSucceed = true;
                roundResult.updateResult(car);
            }
        }
        return roundResult;
    }

    public List<String> getWinners() {
        if (!checkRaceSucceed) {
            return new ArrayList<>();
        }
        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);
        Car winner = sortedCars.get(0);
        return sortedCars.stream()
                .filter(x -> x.isAtSamePositionWith(winner))
                .map(x -> x.toString())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        return ((Race) obj).cars.equals(this.cars) && ((Race) obj).roundResult.equals(this.roundResult);
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