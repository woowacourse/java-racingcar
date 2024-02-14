package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class RoundResult {
    private final List<CarPerformance> carPerformances;

    public RoundResult(List<CarPerformance> carPerformances) {
        this.carPerformances = Collections.unmodifiableList(carPerformances);
    }
}
