package racing.dto;

import java.util.Collections;
import java.util.List;

public class RacingResult {
    private final List<String> names;
    private final List<String> distances;

    public RacingResult(List<String> names, List<String> distances) {
        this.names = Collections.unmodifiableList(names);
        this.distances = Collections.unmodifiableList(distances);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getDistances() {
        return distances;
    }
}
