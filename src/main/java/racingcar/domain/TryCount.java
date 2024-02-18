package racingcar.domain;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;

    private final int value;

    public TryCount(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
