package domain.racing;

public class RacingCount {

    private final int count;

    public RacingCount(final int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("1이상의 숫자가 입력되어야 합니다.");
        }
    }

    public boolean isCountEnd(int count) {
        return this.count < count;
    }
}
