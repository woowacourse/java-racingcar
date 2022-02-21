package racingcar.model;

import java.util.Map;

public class GameResult {

    private Map<String, Integer> positionByName;

    public GameResult(Map<String, Integer> result) {
        this.positionByName = result;
    }

    public Map<String, Integer> getPositionByName() {
        return positionByName;
    }
}
