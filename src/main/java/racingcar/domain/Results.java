package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(List<Result> results) {
        return new Results(results);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
