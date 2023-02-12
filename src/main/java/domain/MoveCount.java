package domain;

public class MoveCount {
    private final String COUNT_RANGE_ERROR_MESSAGE = "시도할 횟수는 1 ~ 1,000까지 입니다.";

    private final int COUNT_LOWER_BOUND_INCLUSIVE = 1;
    private final int COUNT_UPPER_BOUND_INCLUSIVE = 1_000;

    private int count;

    public MoveCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < COUNT_LOWER_BOUND_INCLUSIVE || count > COUNT_UPPER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public void decrease() {
        if (count > 0) {
            --count;
        }
    }

    public boolean isFinished() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }
}
