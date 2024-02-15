package domain;

public class Count {
    private static final int COUNT_LOWER_BOUND = 1;
    private int value;

    public Count(int value) {
        validatePositive(value);
        this.value = value;
    }

    private void validatePositive(int count) {
        if (count < COUNT_LOWER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
