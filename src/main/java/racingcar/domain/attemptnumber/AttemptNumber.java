package racingcar.domain.attemptnumber;

import java.util.Objects;

public class AttemptNumber {
    private static final String NUMBER_RANGE_ERROR = "시도 횟수는 1회 이상이여야 합니다.";
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final int ZERO = 0;

    private int attemptNumber;

    public AttemptNumber(int attemptNumber) {
        validateNumberRange(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    private void validateNumberRange(int attemptNumber) {
        if (attemptNumber < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }

    public boolean canAttempt() {
        if (isRemain()) {
            attemptNumber--;
            return true;
        }
        return false;
    }

    private boolean isRemain() {
        return attemptNumber > ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptNumber that = (AttemptNumber) o;
        return attemptNumber == that.attemptNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptNumber);
    }
}
