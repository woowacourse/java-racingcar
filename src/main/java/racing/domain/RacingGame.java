package racing.domain;

import racing.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RandomNumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGame(final RandomNumberGenerator numberGenerator, final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        cars.moveAll(numberGenerator);
        validateTryCount(tryCount);
        tryCount--;
    }

    private void validateTryCount(final int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("실행 횟수 보다 많이 실행할 수 없습니다.");
        }
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
        return tryCount <= 0;
    }
}
