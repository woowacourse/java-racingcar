package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.NumberGenerator;
import racing.RandomNumberGenerator;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGame(NumberGenerator numberGenerator, int tryCount, Cars cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public RacingGame(int tryCount, Cars cars) {
        this(new RandomNumberGenerator(), tryCount, cars);
    }

    public void playOneRound() {
        cars.moveAll(numberGenerator);
        tryCount--;
    }

    public boolean isEnd() {
        return tryCount == 0;
    }

    public List<String> getWinnerNames() {
        return cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
