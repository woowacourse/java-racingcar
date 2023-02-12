package racingcar.domain;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        validateRange(min, max);
        this.min = min;
        this.max = max;
    }

    private void validateRange(int min, int max){
        if(min >= max){
            throw new IllegalArgumentException("Range의 max값은 min값보다 커야합니다.");
        }
    }

    public Boolean isInRange(int number) {
        return min <= number && number <= max;
    }
}