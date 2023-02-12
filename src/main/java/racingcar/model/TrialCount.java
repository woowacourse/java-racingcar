package racingcar.model;

public class TrialCount {
    static private final String COUNT_EXCEPTION_MESSAGE = "시도 횟수는 0보다 커야 합니다.";

    private final Integer value;

    public TrialCount(int value) {
        validate(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(COUNT_EXCEPTION_MESSAGE);
        }
    }
}
