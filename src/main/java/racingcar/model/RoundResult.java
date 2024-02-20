package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoundResult {
    private final List<String> names;
    private final List<Integer> positions;

    public RoundResult(List<String> names, List<Integer> positions) {
        this.names = names;
        this.positions = positions;
    }

    private int getMaxPosition() {
        return positions.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> calculateWinners() {
        return IntStream.range(0, names.size())
                .filter(idx -> positions.get(idx).equals(getMaxPosition()))
                .mapToObj(names::get)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
