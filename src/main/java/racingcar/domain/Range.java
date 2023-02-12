package racingcar.domain;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        if (max < min) {
            int temp = min;
            min = max;
            max = temp;
        }
        this.min = min;
        this.max = max;
    }

    public Boolean isInRange(int number) {
        return min <= number && number <= max;
    }
}