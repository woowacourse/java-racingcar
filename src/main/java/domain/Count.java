package domain;

public class Count {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 100;
    private final int count;

    public Count(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (!(count >= MIN_COUNT && count <= MAX_COUNT)) {
            throw new IllegalArgumentException("횟수는 1에서 100사이로 입력해주세요.");
        }
    }

    public static Count from(int count) {
        return new Count(count);
    }

    public static Count init() {
        return new Count(1);
    }

    public boolean isGreaterOrThan(int currentCount) {
        return currentCount <= count;
    }


}
