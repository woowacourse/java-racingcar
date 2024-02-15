package domain;

public class Count {
    private final int count;

    public Count(int count) {
        this.count = count;
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
