package domain;

public class TryCount {

    private static final int EXCEPTION_FLAG = 0;
    private static final int DEDUCT_STEP = 1;
    private static final String ENTER_POSITIVE_INTEGER = "[ERROR] 양의 정수를 입력해주세요.";
    private final int tryCount;

    public TryCount(final int count) {
        validateInputRange(count);
        this.tryCount = count;
    }

    private TryCount(final int count, final int deductValue) {
        this.tryCount = count - deductValue;
    }

    private void validateInputRange(final int inputCount) {
        if (inputCount <= EXCEPTION_FLAG) {
            throw new IllegalArgumentException(ENTER_POSITIVE_INTEGER);
        }
    }

    public TryCount deduct() {
        return new TryCount(tryCount, DEDUCT_STEP);
    }

    public boolean isOpportunity() {
        return this.tryCount != EXCEPTION_FLAG;
    }
}
