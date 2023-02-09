package domain;

public class GameCount {
    private final String INVALID_COUNT = "시도할 횟수는 1 ~ 10억까지 입니다.";
    private final String NOT_A_NUMBER = "시도할 횟수는 숫자를 입력해야 합니다.";

    private final int MAX_COUNT = 1_000_000_000;
    private final int MIN_COUNT = 1;

    private int count;

    public GameCount(String countInput) {
        validate(countInput);
        this.count = Integer.parseInt(countInput);
    }

    public void play() {
        --count;
    }

    public boolean isOver() {
        return count == 0;
    }

    private void validate(String countInput) {
        int count;

        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }

        if (count < MIN_COUNT || count > MAX_COUNT)
            throw new IllegalArgumentException(INVALID_COUNT);
    }
}
