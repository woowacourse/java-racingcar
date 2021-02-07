package racingcar.domain;

public class Round {
    private static final int MIN_COUNT_SIZE = 1;
    private final int count;

    private Round(int count) {
        validateRoundCount(count);
        this.count = count;
    }

    public static Round of(int count) {
        return new Round(count);
    }

    private void validateRoundCount(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new IllegalArgumentException("시도할 횟수는 1이상 이어야 합니다.");
        }
    }
}
