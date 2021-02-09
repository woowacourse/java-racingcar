package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Results {
    private static final int GAP_WITH_SIZE_AND_INDEX = 1;
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(List<Result> results) {
        return new Results(results);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public int getMaxPosition() {
        Result result = getLastResult();
        return result.getMaxPosition();
    }

    public Result getLastResult() {
        int lastIndex = results.size() - GAP_WITH_SIZE_AND_INDEX;
        return results.get(lastIndex);
    }

    public boolean isMaxPosition(int position) {
        return getMaxPosition() == position;
    }

    public List<String> getWinners() {
        Result result = getLastResult();
        List<CarState> carStates = result.getCarStates();
        return carStates.stream()
            .filter(carState -> isMaxPosition(carState.getPosition()))
            .map(CarState::getName)
            .collect(Collectors.toList());
    }
}
