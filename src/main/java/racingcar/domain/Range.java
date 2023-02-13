package racingcar.domain;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range 객체의 생성자에 잘못된 인자가 전달되었습니다.");
        }
        this.min = min;
        this.max = max;
    }

    public Boolean isInRange(int number) {
        return min <= number && number <= max;
    }
}