package domain;

public class Count {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 100;

    private int count;

    public Count(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count <= MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.COUNT_RANGE);
        }
    }

    public boolean hasCount() {
        return count > MIN_COUNT;
    }

    public void minusOneCount() {
        count--;
    }
}
