package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;

public class Referee {

    private final Map<String, Integer> carsPosition;

    public Referee(Map<String, Integer> carsPosition) {
        this.carsPosition = carsPosition;
    }

    public List<String> getWinners() {
        final int winnerPosition = getWinnerPosition();

        return carsPosition.entrySet().stream()
                .filter(entry -> entry.getValue() == winnerPosition)
                .map(Entry::getKey)
                .toList();
    }

    private int getWinnerPosition() {
        final OptionalInt winnerPosition = carsPosition.values().stream()
                .mapToInt(position -> position)
                .max();

        return winnerPosition.orElse(0);
    }
}
