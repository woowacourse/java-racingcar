package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<String> winners;

    public Winners(final List<String> winnersWithNull) {
        this.winners = winnersWithNull.stream()
            .filter(name -> !name.isEmpty())
            .collect(collectingAndThen(toList(),
                Collections::unmodifiableList));
    }

    public boolean contains(String name) {
        return winners.contains(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
