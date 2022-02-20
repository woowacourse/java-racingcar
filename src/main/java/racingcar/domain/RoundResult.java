package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {
    private static final String STEP = "-";

    private final List<String> result = new ArrayList<>();

    public void save(String name, int position) {
        result.add(name + " : " + STEP.repeat(position));
    }

    public void roundEnd() {
        result.add("");
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }
}
