package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class GameWinners {
    private static final String WINNER_SEPERATOR = ", ";
    private final List<String> winners;

    public GameWinners(List<String> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return winners.stream()
                .collect(Collectors.joining(WINNER_SEPERATOR));
    }
}
