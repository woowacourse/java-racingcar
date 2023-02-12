package racingcar.domain;

public class TrialCount {
    private final int value;
    private static final String COUNT_EXCEPTION_MESSAGE = "시도 횟수는 0보다 커야 합니다.";
    private static final int MIN_SIZE_VALUE = 0;

    public TrialCount(int value) {
        validateSize(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateSize(int value) {
        if (value <= MIN_SIZE_VALUE) {
            throw new IllegalArgumentException(COUNT_EXCEPTION_MESSAGE);
        }
    }
}
