package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.NumberGenerator;
import racing.RandomNumberGenerator;

public class RacingGame {
    public static final int MAX_TRY_COUNT_BOUND = 100;

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int tryCount;

    public RacingGame(NumberGenerator numberGenerator, int tryCount, Cars cars) {
        validateTryCount(tryCount);
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public RacingGame(int tryCount, Cars cars) {
        this(new RandomNumberGenerator(), tryCount, cars);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount > MAX_TRY_COUNT_BOUND) {
            throw new IllegalArgumentException("시도 횟수는 100회 이하만 가능합니다 현재 : " + tryCount + "회");
        }
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
