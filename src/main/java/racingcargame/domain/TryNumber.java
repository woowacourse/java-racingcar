package racingcargame.domain;

import racingcargame.exception.InvalidTryNumberException;

public class TryNumber {
    private static final int MIN_TRY_NUMBER = 1;

    private int tryNumber;

    public TryNumber(String inputNumber) {
        int number = getNumber(inputNumber);
        checkUnderMinTryNumber(number);
        this.tryNumber = number;
    }

    private int getNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("※시도 회수는 숫자(정수)만 입력해 주세요.");
        }
    }

    private void checkUnderMinTryNumber(int number) {
        if (number < MIN_TRY_NUMBER) {
            throw new InvalidTryNumberException("※시도 회수는 " + MIN_TRY_NUMBER + " 이상의 숫자만 입력해 주세요.");
        }
    }

    public boolean next() {
        return tryNumber-- != 0;
    }
}
