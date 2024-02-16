package racingcar.model;

import java.util.List;

public class TotalResult {
    private final List<RoundResult> totalResult;

    public TotalResult(List<RoundResult> totalResult) {
        this.totalResult = totalResult;
    }

    public List<String> getWinner() {
        RoundResult roundResult = totalResult.get(totalResult.size() - 1);
        return roundResult.selectWinners();
    }

    public List<RoundResult> getTotalResult() {
        return totalResult;
    }
}
