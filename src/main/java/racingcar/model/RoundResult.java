package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<CarResult> carResults;

    private RoundResult(final List<CarResult> carResults) {
        this.carResults = carResults;
    }

    public static RoundResult from(final List<Car> cars) {
        final List<CarResult> carResults = cars.stream()
                .map(CarResult::from)
                .toList();

        return new RoundResult(carResults);
    }

    public List<CarResult> getCarResult() {
        return Collections.unmodifiableList(carResults);
    }
}
