package domain;

public class TryCount {
    private int value;

    public TryCount(int value) {
        if(value < 1) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
