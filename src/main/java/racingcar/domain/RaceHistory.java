package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RaceHistory {
    private final List<Map<String, Integer>> history = new LinkedList<>();

    public void add(Map<String, Integer> roundResult) {
        history.add(roundResult);
    }

    public List<String> getFinalWinners() {
        Map<String, Integer> lastRoundResult = history.get(history.size() - 1);
        int highestScore = lastRoundResult.values().stream()
                .max(Integer::compare)
                .orElse(0);

        return lastRoundResult.entrySet().stream()
                .filter(entry -> entry.getValue().equals(highestScore))
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Map<String, Integer>> getRaceHistory() {
        return history;
    }
}