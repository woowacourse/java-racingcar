package domain;

public class TryCount {

    private static final int EXCEPTION_FLAG = 0;
    private static final String ENTER_POSITIVE_INTEGER = "[ERROR] 양의 정수를 입력해주세요.";
    private final int tryCount;

    public TryCount(final String input) {
        this.tryCount = convertAndValidate(input);
    }

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    private int convertAndValidate(String input) {
        int tryCount = Integer.parseInt(input);

        validateInputRange(tryCount);

        return tryCount;
    }

    private void validateInputRange(final int inputCount) {
        if (inputCount <= EXCEPTION_FLAG) {
            throw new IllegalArgumentException(ENTER_POSITIVE_INTEGER);
        }
    }

    public TryCount deduct() {
        return new TryCount(tryCount - 1);
    }

    public boolean isOpportunity() {
        return this.tryCount != EXCEPTION_FLAG;
    }
}
