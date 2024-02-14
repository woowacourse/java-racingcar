package racing.domain;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
