package domain;

import java.util.Objects;

public class Attempts {
    private static final int MIN_ATTEMPTS = 1;
    private static final int MAX_ATTEMPTS = 10;

    private int numberOfAttempts;


    public Attempts(final int numberOfAttempts) {
        if (isNumberOfAttemptsOutOfRange(numberOfAttempts)) {
            throw new IllegalArgumentException(MIN_ATTEMPTS + "부터 " + MAX_ATTEMPTS + " 이하의 숫자를 입력하세요.\n");
        }

        this.numberOfAttempts = numberOfAttempts;
    }

    private boolean isNumberOfAttemptsOutOfRange(final int numberOfAttempts) {
        return numberOfAttempts < MIN_ATTEMPTS || numberOfAttempts > MAX_ATTEMPTS;
    }

    public boolean isEnd() {
        return numberOfAttempts == 0;
    }

    public void decrease() {
        numberOfAttempts--;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Attempts attempts = (Attempts) o;
        return numberOfAttempts == attempts.numberOfAttempts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfAttempts);
    }
}
