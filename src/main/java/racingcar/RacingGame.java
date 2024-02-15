package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingGame {

    private final int count;
    private final Cars cars;

    public RacingGame(String input, Cars cars) {
        int count = parseInt(input);
        validateCount(count);
        this.count = count;
        this.cars = cars;
    }

    public List<RoundResult> gameStart() {
        List<RoundResult> gameResult = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            gameResult.add(createRoundResult(cars.getCarStatus()));
        }
        return gameResult;
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private RoundResult createRoundResult(LinkedHashMap<String, Integer> carStatus) {
        return new RoundResult(carStatus);
    }

}
