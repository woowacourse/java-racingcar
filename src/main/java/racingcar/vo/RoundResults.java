package racingcar.vo;

import java.util.ArrayList;
import java.util.List;

public class RoundResults {

    private List<RoundResult> results = new ArrayList<>();

    public RoundResults() {
    }

    public void add(RoundResult result) {
        results.add(result);
    }

    public RoundResult poll() {
        return results.remove(0);
    }

    public boolean hasResult() {
        return results.size() > 0;
    }
}
