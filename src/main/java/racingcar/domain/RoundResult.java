package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {
    private static final String STEP = "-";

    private final List<String> result = new ArrayList<>();

    public void save(final String name, final int position) {
        result.add(name + " : " + STEP.repeat(position));
    }

    public void roundEnd() {
        result.add("");
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }

    @Override
    public String toString() {
        return String.join("\n", result);
    }
}
