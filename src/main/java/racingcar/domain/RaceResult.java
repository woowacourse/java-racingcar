package racingcar.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RaceResult {
    private final List<RoundResult> roundResults = new LinkedList<>();

    public void record(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> getRoundResults() {
        return Collections.unmodifiableList(roundResults);
    }
}
