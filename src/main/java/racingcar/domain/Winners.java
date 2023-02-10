package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public List<Winner> getWinners() {
        return winners;
    }

    public String toString() {

        return winners.stream()
                .map(Winner::getName)
                .collect(Collectors.joining(", "));
    }
}
