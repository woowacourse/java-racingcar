package racingcar.model;

import java.util.Map;

public class RaceResult {

    private final Map<Car, Integer> result;

    public RaceResult(Map<Car, Integer> result) {
        this.result = result;
    }

    public Map<Car, Integer> getResult() {
        return result;
    }
}
