package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final int GAP_WITH_SIZE_AND_INDEX = 1;

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(List<Result> results) {
        return new Results(results);
    }

    public List<String> findWinners() {
        Result lastResult = results.get(results.size() - GAP_WITH_SIZE_AND_INDEX);
        List<Car> cars = lastResult.getResult();
        return cars.stream()
                .filter(car -> car.isSamePosition(getMaxPosition(cars)))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
