package racingcar.controller.response;

import racingcar.domain.car.Cars;

import java.util.Map;
import java.util.stream.Collectors;

public class MovedResult {

    private final Map<String, Integer> positionByName;

    public MovedResult(final Cars cars) {
        positionByName = cars.getCars()
                .stream()
                .collect(Collectors.toMap(
                        car -> car.getName().getValue(),
                        car -> car.getPosition().getValue())
                );
    }

    public Map<String, Integer> positionByNameMap() {
        return positionByName;
    }
}
