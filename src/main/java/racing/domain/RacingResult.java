package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResult {

    private final Map<String, Integer> history;

    public RacingResult(Map<String, Integer> history) {
        this.history = history;
    }

    public Map<String, Integer> getHistory() {
        return history;
    }

    public List<String> getWinner() {
        Integer maxValue = Collections.max(history.values());

        return history.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
