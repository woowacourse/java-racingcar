package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoundResult {
    private final Map<String, Integer> roundResult;

    public RoundResult(List<Car> cars) {
        this.roundResult = recordRoundResult(cars);
    }

    private Map<String, Integer> recordRoundResult(List<Car> cars) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }

        return result;
    }

    public Map<String, Integer> getRoundResult() {
        return Collections.unmodifiableMap(roundResult);
    }
}
