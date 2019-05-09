package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy;
    private final List<Car> cars = new ArrayList<>();
    private final List<Integer> snapshots = new ArrayList<>();

    public Race (List<String> namesList, MovementStrategy strategy) {
        namesList.forEach(name -> cars.add(new Car(name)));
        this.strategy = strategy;
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
        Collections.sort(snapshots);
        Collections.reverse(snapshots);
        return cars.stream().filter(x -> x.isAt(snapshots.get(0))).collect(Collectors.toList());
    }
}
//JDK 변경