package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<List<Integer>> gameResult = new ArrayList<>();

    public void addResult(List<Integer> roundResult) {
        gameResult.add(roundResult);
    }

    private List<Integer> getFinalResult() {
        return gameResult.get(gameResult.size() - 1);
    }

    private int getMaxPosition() {
        return getFinalResult().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> getWinners(List<String> carNames) {
        List<String> winners = new ArrayList<>();
        List<Integer> finalResult = getFinalResult();
        for(int i = 0; i < finalResult.size(); i++) {
            if (finalResult.get(i) == getMaxPosition()) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    public List<List<Integer>> getGameResult() {
        return gameResult;
    }
}
