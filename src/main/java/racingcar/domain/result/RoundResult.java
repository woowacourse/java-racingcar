package racingcar.domain.result;

import java.util.List;
import racingcar.domain.car.Car;

public record RoundResult(List<CarResult> carResults) {

    public static RoundResult from(final List<Car> cars) {
        final List<CarResult> carResults = cars.stream()
                .map(CarResult::from)
                .toList();

        return new RoundResult(carResults);
    }
}
