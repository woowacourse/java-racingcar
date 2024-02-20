package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<RoundResult> gameResult = new ArrayList<>();

    public void addResult(RoundResult roundResult) {
        gameResult.add(roundResult);
    }

    private RoundResult getFinalResult() {
        return gameResult.get(gameResult.size() - 1);
    }

    public List<String> getWinners() {
        return getFinalResult().calculateWinners();
    }

    public List<RoundResult> getGameResult() {
        return gameResult;
    }
}
