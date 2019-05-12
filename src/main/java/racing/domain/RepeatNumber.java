package racing.domain;

import racing.view.ConsoleMessages;

public class RepeatNumber {
    private int number;

    public RepeatNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_INVALID_REPEAT_NUMBER.getMessage());
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
