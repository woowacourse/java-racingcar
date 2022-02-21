package racingcar.domain;

public class Attempt {

    private static final String MUST_BE_POSITIVE = "[ERROR] 1미만의 시도횟수는 허용되지 않습니다.";

    private int attempt;

    public Attempt(int attempt) {
        validateAttempt(attempt);
        this.attempt = attempt;
    }

    public boolean isOver() {
        return attempt == 0;
    }

    public void endTurn() {
        this.attempt--;
    }

    private void validateAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }
}
