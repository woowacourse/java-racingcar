package racingcar.domain;

public class AttemptNumber {
    private static final int MIN_ATTEMPT_NUMBER = 1;

    private int attemptNumber;

    public AttemptNumber(int attemptNumber) {
        validateNumberRange(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    private void validateNumberRange(int attemptNumber) {
        if (attemptNumber < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }
}
