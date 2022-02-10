package racingcar.domain;

public class Attempt {
    private final int attempt;

    public Attempt(int attempt) {
        this.attempt = attempt;
    }
    
    public boolean isSame(int nowAttempt) {
        return attempt == nowAttempt;
    }
}
