package racingcar.domain.result;

import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

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
        Position maxPosition = lastResult.getMaxPosition();
        List<Car> cars = lastResult.getResult();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
