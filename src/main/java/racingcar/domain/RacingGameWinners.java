package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingGameWinners {
    private final List<Car> winners;

    public RacingGameWinners(List<Car> winners) {
        this.winners = winners;
    }

    public final List<Car> getWinners() {
        return Collections.unmodifiableList(this.winners);
    }
}
