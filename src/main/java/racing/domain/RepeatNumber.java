package racing.domain;

import racing.view.ErrorMessages;

public class RepeatNumber {
    private int number;

    public RepeatNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_REPEAT_NUMBER.getMessage());
        }
        this.number = number;
    }

    public RepeatNumber(String number) {
        this(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }
}
