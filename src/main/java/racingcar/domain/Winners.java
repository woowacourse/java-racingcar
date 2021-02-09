package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners of(Cars cars) {
        List<String> winners = cars.findWinners();
        return new Winners(winners);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
