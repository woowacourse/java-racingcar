package racingcar.model;

import java.util.List;
import java.util.Map;

public class RoundResult {

    private final Map<CarName, Position> result;

    public RoundResult(Map<CarName, Position> result) {
        this.result = result;
    }

    public Map<CarName, Position> getResult() {
        return result;
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();
        return result.keySet()
                .stream()
                .filter(key -> result.get(key).getPosition() == maxPosition)
                .map(CarName::getName)
                .toList();
    }

    private int getMaxPosition() {
        return result.values()
                .stream()
                .mapToInt(Position::getPosition)
                .max()
                .orElse(0);
    }
}
