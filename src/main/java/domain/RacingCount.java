package domain;

public class RacingCount {

    private final int count;

    public RacingCount(final int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(final int count) {
        if (count <= 0) {
            throw new RuntimeException("0이상의 숫자가 입력되어야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
