package domain;

public class Count {
    private final int count;

    public Count(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (!(count >= 1 && count <= 100)) {
            throw new IllegalArgumentException();
        }
    }

    public static Count from(int count) {
        return new Count(count);
    }

    public static Count init() {
        return new Count(0);
    }

    public boolean isValidRange(int currentCount) {
        return currentCount <= count;
    }
}
