package racingcar.domain.result;

import java.util.Collections;
import java.util.List;

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
        Result lastResult = getLastResult();
        return lastResult.getWinners();
    }

    private Result getLastResult() {
        return results.get(results.size() - GAP_WITH_SIZE_AND_INDEX);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
