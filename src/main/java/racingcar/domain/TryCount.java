package racingcar.domain;

public class TryCount {
    public static final int POSITIVE_CRITERIA = 1;
    int tryCount;

    public TryCount(int tryCount) {
        if (tryCount < POSITIVE_CRITERIA) {
            throw new IllegalArgumentException(POSITIVE_CRITERIA + "이상의 수를 입력해야합니다.");
        }
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
