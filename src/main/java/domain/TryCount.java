package domain;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 양의 정수여야 합니다." +
                    "입력값 : " + tryCount);
        }
    }
}
