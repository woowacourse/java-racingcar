package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars = new ArrayList<>();
    private final List<Integer> snapshots = new ArrayList<>();

    public Race(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public Race(List<Car> cars, boolean getCars) {
        cars.forEach(car -> this.cars.add(car));
    }

    public void startRoundAndSaveSnapshot() {
        for (int i = 0; i < cars.size(); i++) {
            snapshots.add(cars.get(i).moveAndReturnPosition(strategy));
        }
    }

    public List<Integer> getSnapshots() {
        return snapshots;
    }

    public List<Car> getWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream().filter(x -> x.isAtSamePositionWith(winner)).collect(Collectors.toList());
    }
}