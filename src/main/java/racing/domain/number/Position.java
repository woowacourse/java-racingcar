package racing.domain.number;

public class Position implements Number {
    private static final int ZERO = 0;

    private int value;

    private Position(final int value) {
        validatePosition(value);
        this.value = value;
    }

    public static Position of() {
        return new Position(ZERO);
    }

    public static Position of(final int value) {
        return new Position(value);
    }

    private void validatePosition(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("위치 값은 0 이상이어야 합니다.");
        }
    }

    public void add() {
        this.value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
