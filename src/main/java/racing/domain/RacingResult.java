package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingResult {

    private final Map<Name, Position> history;

    public RacingResult(Map<Name, Position> history) {
        this.history = history;
    }

    public Map<Name, Position> getHistory() {
        return history;
    }

    public List<Name> pickWinner() {
        Integer maxValue = findMaxPosition();

        return history.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getPosition() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Integer findMaxPosition() {
        return history.values()
                .stream()
                .map(Position::getPosition)
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
}
