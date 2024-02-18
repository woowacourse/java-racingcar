package racingcar.dto;

import java.util.List;
import racingcar.domain.Cars;

public class RoundResult {

    private final List<CarPerformance> carPerformances;

    public RoundResult(Cars cars) {
        this.carPerformances = cars.cars()
                .stream()
                .map(CarPerformance::new)
                .toList();
    }

    public List<CarPerformance> getCarPerformances() {
        return carPerformances;
    }
}
