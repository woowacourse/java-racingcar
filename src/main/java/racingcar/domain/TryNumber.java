package racingcar.domain;

public class TryNumber {
    private static final int MIN_TRY_NUMBER_LIMIT = 1;
    private static final String ERROR_MORE_THAN_MIN_TRY_NUMBER_MESSAGE = "[ERROR] 시도횟수는 최소 1이상의 값만 입력가능합니다.";

    private final int tryNumber;

    public TryNumber(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER_LIMIT) {
            throw new IllegalArgumentException(ERROR_MORE_THAN_MIN_TRY_NUMBER_MESSAGE);
        }

        this.tryNumber = tryNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
