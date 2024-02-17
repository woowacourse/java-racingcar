package racingcar.model;

import java.util.Map;

public class RaceResult {

    private final Map<String, Integer> result;

    public RaceResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
