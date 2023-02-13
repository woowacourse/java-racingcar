package racing.domain;

import racing.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RandomNumberGenerator numberGenerator;
    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(final RandomNumberGenerator numberGenerator, final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = new TryCount(tryCount);
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        cars.moveAll(numberGenerator);
        tryCount.decreaseCount();
    }


    public List<Car> decideResult() {
        return cars.getUnmodifiableCars();
    }

    public List<String> decideWinners() {
        return cars.decideWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isEnd() {
        return tryCount.isEnd();
    }
}
