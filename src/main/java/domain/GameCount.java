package domain;

public class GameCount {
    private final String INVALID_COUNT = "시도할 횟수는 1 ~ 10억까지 입니다.";

    private final int MAX_COUNT = 1_000_000_000;
    private final int MIN_COUNT = 1;

    private int count;

    public GameCount(int count) {
        validate(count);
        this.count = count;
    }

    public void play() {
        --count;
    }

    public boolean isOver() {
        return count == 0;
    }

    private void validate(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT)
            throw new IllegalArgumentException(INVALID_COUNT);
    }
}
