package racingcar.domain;

import java.util.ArrayList;

public class RoundResult {
    private ArrayList<Car> roundResult = new ArrayList<>();

    public RoundResult(ArrayList<Car> roundResult) {
        this.roundResult = roundResult;
    }

    public ArrayList<Car> getRoundResult() {
        return this.roundResult;
    }
}
