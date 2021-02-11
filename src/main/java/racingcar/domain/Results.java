package racingcar.domain;

import java.util.Collections;
import java.util.List;

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

    public List<String> getWinners() {
        Result lastResult = getLastResult();
        return lastResult.getWinners();
    }

    private Result getLastResult() {
        int lastIndex = results.size() - GAP_WITH_SIZE_AND_INDEX;
        return results.get(lastIndex);
    }
}
