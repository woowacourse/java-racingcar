package util;

public class Count {

    private static final int MIN_COUNT_NUMBER = 0;
    private int count;

    public Count(int count) {
        this.count = count;

        if (!checkValid(this.count)) {
            throw new IllegalArgumentException("횟수는 양의정수만 가능합니다.");
        }
    }

    private boolean checkValid(int count) {
        return count > MIN_COUNT_NUMBER;
    }

    public int getMoveCount() {
        return this.count;
    }
}
