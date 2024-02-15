package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class RoundResult {

    private LinkedHashMap<String, Integer> result;

    public RoundResult(LinkedHashMap<String, Integer> result) {
        this.result = result;
    }

    public LinkedHashMap<String, Integer> getResult() {
        return result;
    }

    public List<String> getWinner() {
        int maxPosition = Collections.max(result.values());
        return result.keySet()
                .stream()
                .filter(key -> result.get(key) == maxPosition)
                .toList();
    }
}
