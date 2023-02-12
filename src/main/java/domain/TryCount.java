package domain;

public class TryCount {

    public static final int MIN_TRY_COUNT = 1;
    public static final int TRY_COUNT_LIMIT = 100;

    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다." +
                    "입력값 : " + tryCount);
        }
        if (tryCount > TRY_COUNT_LIMIT) {
            throw new IllegalArgumentException("시도할 회수는 " + TRY_COUNT_LIMIT +"회 이하여야 합니다.");
        }
    }
}
