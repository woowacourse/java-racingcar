package racingcar.domain;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Boolean isInRange(int number) {
        if (min <= number && number <= max) {
            return true;
        }
        return false;
    }
}