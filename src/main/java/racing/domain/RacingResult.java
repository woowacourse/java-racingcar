package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResult {

    private final Map<Name, Integer> history;

    public RacingResult(Map<Name, Integer> history) {
        this.history = history;
    }

    public Map<Name, Integer> getHistory() {
        return history;
    }

    public List<Name> pickWinner() {
        Integer maxValue = Collections.max(history.values());

        return history.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
