package racingcar.dto;

import java.util.Collections;
import java.util.List;

public record RoundResult(List<CarPerformance> carPerformances) {

    public RoundResult(List<CarPerformance> carPerformances) {
        this.carPerformances = Collections.unmodifiableList(carPerformances);
    }
}
