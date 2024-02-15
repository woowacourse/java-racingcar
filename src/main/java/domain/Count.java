package domain;

public class Count {
    private int count;

    public Count(int count) {
        validatePositive(count);
        this.count = count;
    }

    private void validatePositive(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }
}
