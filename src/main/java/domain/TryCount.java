package domain;

public class TryCount {

    private static final int MINIMUM_TRY_COUNT = 2;
    private static final int MAXIMUM_TRY_COUNT = 10;

    private final int tryCount;

    public TryCount(final int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(final int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT || tryCount > MAXIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("2 이상, 10 이하의 수를 입력해주세요.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
