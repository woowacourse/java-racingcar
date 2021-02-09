package racing.domain.number;

public class TryCount {
    private static final int ZERO = 0;

    private int value;

    public TryCount(final int value) {
        validateTryCounts(value);
        this.value = value;
    }

    private void validateTryCounts(final int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(String.format("시도횟수는 1회 이상이어야 합니다. 현재 입력값: %d", value));
        }
    }

    public boolean reduce() {
        if (value <= ZERO) {
            return false;
        }
        this.value--;
        return true;
    }
}
