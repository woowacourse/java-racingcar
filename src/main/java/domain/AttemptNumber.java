package domain;

public class AttemptNumber {

    private int attemptNumber;

    public AttemptNumber(final int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void decrease() {
        attemptNumber--;
    }

    public boolean isAttemptRemain() {
        return attemptNumber != 0;
    }
}
