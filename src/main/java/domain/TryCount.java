package domain;

public class TryCount {
    private int value;

    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 5;

    public TryCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_TRY_COUNT || value > MAX_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
