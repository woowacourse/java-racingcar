package racingcar.domain;

public class TrialCount {
    private final int value;
    private final String COUNT_EXCEPTION_MESSAGE = "시도 횟수는 0보다 커야 합니다.";

    public TrialCount(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(COUNT_EXCEPTION_MESSAGE);
        }
    }
}
