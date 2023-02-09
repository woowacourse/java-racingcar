package racingcar.domain.result;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

    private final List<Map<String, Integer>> results;

    public Result(List<Map<String, Integer>> results) {
        this.results = results;
    }

    public List<Map<String, Integer>> getResults() {
        return results;
    }

    public List<String> findWinners() {
        Map<String, Integer> lastResult = getLastResult();
        return lastResult.keySet()
                .stream()
                .filter(key -> lastResult.get(key) == findMaxPosition(lastResult))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getLastResult() {
        return results.get(results.size() - 1);
    }

    private int findMaxPosition(Map<String, Integer> lastResult) {
        return lastResult.values()
                .stream()
                .max(Comparator.comparing(x -> x))
                .orElseThrow(IllegalArgumentException::new);
    }
}
