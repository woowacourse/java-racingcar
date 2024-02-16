package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class TotalResult {
    private final List<RoundResult> totalResult = new ArrayList<>();
    private RoundResult lastResult;

    public void addResult(RoundResult roundResult) {
        totalResult.add(roundResult);
        lastResult = roundResult;
    }

    public List<String> getWinner() {
        return lastResult.selectWinners();
    }

    public List<RoundResult> getTotalResult() {
        return totalResult;
    }
}
