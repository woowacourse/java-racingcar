package racingcargame.domain;

public class TryLimitNumber {
    private static final int MIN_TRY_NUMBER = 1;

    private final int number;

    public TryLimitNumber(int number) {
        checkExceedRange(number);
        this.number = number;
    }

    private void checkExceedRange(int number) {
        if (number < MIN_TRY_NUMBER) {
            System.out.println("1 이상의 숫자만 입력 가능합니다.");
            throw new RuntimeException();
        }
    }

    public boolean isBiggerThan(int tryNumber) {
        return tryNumber < this.number;
    }
}
