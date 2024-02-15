package domain;

public class RacingCount {

    public static final int MIN_ROUND_COUNT = 1;

    private final int count;

    public RacingCount(final int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(final int count) {
        if (count < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("1이상의 숫자가 입력되어야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
