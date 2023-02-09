package racingcar.domain.result;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Map<String, Integer> lastResult = results.get(results.size() - 1);

        int maxPosition = findMaxPosition(lastResult);

        return lastResult.keySet()
                .stream()
                .filter(key -> lastResult.get(key) == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition(Map<String, Integer> lastResult) {
        Optional<Integer> value = lastResult.values()
                .stream()
                .max(Comparator.comparing(x -> x));

        return value.orElseThrow(IllegalArgumentException::new);
    }
}
