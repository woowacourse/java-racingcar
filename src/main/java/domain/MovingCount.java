package domain;

public class MovingCount {
    private final Integer count;

    public MovingCount(Integer count) {
        validateCountRange(count);
        this.count = count;
    }

    private void validateCountRange(Integer count) {
        if (count < 1) {
            throw new IllegalArgumentException("이동 횟수는 1이상의 수자만 가능합니다.");
        }
    }

    public Integer getCount() {
        return count;
    }
}
