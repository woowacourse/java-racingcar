package racingcar.domain;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 1_000;

    private final int tryCount;

    public TryCount(final int tryCount) {
        validateTryCountRange(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCountRange(final int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
        if (tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %,d 이하여야 합니다.", MAX_TRY_COUNT)
            );
        }
    }
}
