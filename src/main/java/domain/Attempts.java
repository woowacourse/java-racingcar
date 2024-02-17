package domain;

public record Attempts(int numberOfAttempts) {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 10;

    public Attempts {
        if (isNumberOfAttemptsOutOfRange(numberOfAttempts)) {
            throw new IllegalArgumentException("1부터 10 이하의 숫자를 입력하세요. ");
        }
    }

    private boolean isNumberOfAttemptsOutOfRange(int numberOfAttempts) {
        return numberOfAttempts < START_RANGE || numberOfAttempts > END_RANGE;
    }
}
