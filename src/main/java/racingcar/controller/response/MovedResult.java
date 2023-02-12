package racingcar.controller.response;

import racingcar.domain.car.Cars;

import java.util.Map;
import java.util.stream.Collectors;

public class MovedResult {

    private final Map<String, Integer> positionByName;

    public MovedResult(final Cars cars) {
        positionByName = cars.cars()
                .stream()
                .collect(Collectors.toMap(
                        car -> car.name().value(),
                        car -> car.position().value())
                );
    }

    public Map<String, Integer> positionByNameMap() {
        return positionByName;
    }
}
