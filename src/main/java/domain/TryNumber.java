package domain;

import exception.NotNumberPositiveException;

public class TryNumber {
    private int number;
    public TryNumber(int number) {
        validatePositiveMoveCount(number);
        this.number = number;
    }

    public boolean isTryable() {
        return number > 0;
    }

    public void decrease() {
        number --;
    }

    private void validatePositiveMoveCount(int number) {
        if (number <= 0) {
            throw new NotNumberPositiveException("시도 횟수는 양수인 정수만 가능합니다.");
        }
    }
}
