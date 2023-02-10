package racingcar.controller.response;

import racingcar.domain.car.Cars;

import java.util.Map;
import java.util.stream.Collectors;

public class MovedResultResponse {

    private final Map<String, Integer> positionMap;

    public MovedResultResponse(final Cars cars) {
        positionMap = cars.getCars()
                .stream()
                .collect(Collectors.toMap(
                        car -> car.getName().getValue(),
                        car -> car.getPosition().getValue())
                );
    }

    public Map<String, Integer> getPositionMap() {
        return positionMap;
    }
}
