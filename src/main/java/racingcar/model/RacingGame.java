package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class RacingGame {
    CarGroup cars;
    int moveCount;

    public RacingGame(CarGroup cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public List<Map<String, Integer>> race() {
        return IntStream.range(0, moveCount)
                .mapToObj(c -> cars.playRound())
                .toList();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
