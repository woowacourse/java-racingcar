package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {

    private final List<Car> winners;

    public RacingGameResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
