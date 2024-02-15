package domain;

public class Count {
    private static final int COUNT_LOWER_BOUND = 1;
    private int count;

    public Count(int count) {
        validatePositive(count);
        this.count = count;
    }

    private void validatePositive(int count) {
        if (count < COUNT_LOWER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public int get() {
        return count;
    }
}
