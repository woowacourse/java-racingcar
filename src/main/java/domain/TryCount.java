package domain;

public class TryCount {

    private static final int EXCEPTION_FLAG = 0;

    private static final String ENTER_POSITIVE_INTEGER = "[ERROR] 양의 정수를 입력해주세요.";

    private final int tryCount;

    public TryCount(final String inputCount) {
        this.tryCount = validateTryCount(inputCount);
    }

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    private int validateTryCount(final String inputCount) {
        int tryCount = Integer.parseInt(inputCount);

        if (tryCount <= EXCEPTION_FLAG) {
            throw new IllegalArgumentException(ENTER_POSITIVE_INTEGER);
        }

        return tryCount;
    }

    public TryCount deduct() {
        return new TryCount(tryCount - 1);
    }

    public boolean isOpportunity() {
        return this.tryCount != EXCEPTION_FLAG;
    }
}
