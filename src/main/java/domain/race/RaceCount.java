package domain.race;

public class RaceCount {
    private final Integer value;

    public RaceCount(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException("횟수가 0보다 커야합니다.");
        }
    }

    public Integer getValue() {
        return value;
    }
}
