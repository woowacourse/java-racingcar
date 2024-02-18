package domain.race;

public class RaceCount {
    private final int value;

    public RaceCount(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException("횟수가 0보다 커야합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
