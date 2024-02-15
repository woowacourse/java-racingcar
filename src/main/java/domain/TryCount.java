package domain;

public class TryCount {
    private int value;

    public TryCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
