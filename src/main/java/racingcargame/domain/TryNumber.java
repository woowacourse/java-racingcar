package racingcargame.domain;

public class TryNumber {
    private static final int MIN_TRY_NUMBER = 1;

    private final int number;

    public TryNumber(int number) {
        checkExceedRange(number);
        this.number = number;
    }

    private void checkExceedRange(int number) {
        if (number < MIN_TRY_NUMBER) {
            throw new RuntimeException("1 이상의 숫자만 입력 가능합니다.");
        }
    }
}
