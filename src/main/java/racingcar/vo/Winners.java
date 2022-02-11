package racingcar.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final String NAME_DELIMITER = ", ";

    private final List<Name> winners;

    public Winners(List<Name> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return winners.stream()
            .map(Name::toString)
            .collect(Collectors.joining(NAME_DELIMITER));
    }
}
