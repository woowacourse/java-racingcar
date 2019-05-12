package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private List<Car> roundResult = new ArrayList<>();

    public RoundResult(List<Car> roundResult) {
        this.roundResult = roundResult;
    }

    public List<Car> getRoundResult() {
        return this.roundResult;
    }
}
