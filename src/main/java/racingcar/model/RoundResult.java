package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<CarResult> carResults;

    public RoundResult(final List<CarResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarResult> getCarResult() {
        return Collections.unmodifiableList(carResults);
    }
}
