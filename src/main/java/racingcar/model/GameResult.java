package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<String> carNames;
    private final List<List<Integer>> gameResult = new ArrayList<>();

    public GameResult(List<String> carNames) {
        this.carNames = carNames;
    }

    public void addResult(List<Integer> subResult) {
        gameResult.add(new ArrayList<>(subResult));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<List<Integer>> getGameResult() {
        return gameResult;
    }
}
