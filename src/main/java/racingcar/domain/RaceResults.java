package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public class RaceResults {
    private final List<Map<Car, Integer>> raceResults = new ArrayList<>();

    public void recordResult(final List<Car> cars) {
        final Map<Car, Integer> raceResult = new LinkedHashMap<>();
        for (final Car car : cars) {
            raceResult.put(car, car.getPosition());
        }
        raceResults.add(raceResult);
    }

    public List<Map<Car, Integer>> getRaceResults() {
        return Collections.unmodifiableList(raceResults);
    }

    public List<Car> getRaceWinners() {
        final List<Car> lastRaceResult = getLastResult();

        final Car winner = lastRaceResult.stream()
                .max(Car::compareTo)
                .orElseThrow();

        return lastRaceResult.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .toList();
    }

    private List<Car> getLastResult() {
        return new ArrayList<>(raceResults.get(raceResults.size() - 1).keySet());
    }
}