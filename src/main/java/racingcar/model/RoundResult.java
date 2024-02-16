package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoundResult {

    private Map<String, Integer> result;

    public RoundResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public List<String> selectWinners() {
        int maxPosition = Collections.max(result.values());
        return result.keySet()
                .stream()
                .filter(key -> result.get(key) == maxPosition)
                .toList();
    }
}
