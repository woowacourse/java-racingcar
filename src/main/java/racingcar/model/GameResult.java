package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<List<Car>> gameResult = new ArrayList<>();

    public void addResult(List<Car> subResult) {
        gameResult.add(new ArrayList<>(subResult));
    }

    private List<Car> getFinalResult() {
        return gameResult.get(gameResult.size() - 1);
    }

    private int getMaxPosition() {
        return getFinalResult().stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> getWinners() {
        return getFinalResult().stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<List<Car>> getGameResult() {
        return gameResult;
    }
}
