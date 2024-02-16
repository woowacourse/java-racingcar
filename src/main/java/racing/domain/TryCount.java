package racing.domain;

public class TryCount {

    private int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRemain() {
        return tryCount > 0;
    }

    public void consume() {
        tryCount--;
    }

}
