package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.car.Car;

public class RaceResults {
    private final List<List<Car>> raceResults = new ArrayList<>();

    public void recordResult(final List<Car> cars) {
        raceResults.add(List.copyOf(cars));
    }

    public List<List<Car>> getRaceResults() {
        return Collections.unmodifiableList(raceResults);
    }

    public List<Car> getRaceWinners() {
        final List<Car> lastRaceResult = raceResults.get(raceResults.size() - 1);

        final Car winner = lastRaceResult.stream()
                .max(Car::compareTo)
                .orElseThrow();

        return lastRaceResult.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .toList();
    }
}