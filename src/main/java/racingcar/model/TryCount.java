package racingcar.model;

import racingcar.constants.Constants;

public class TryCount {
    private int value;

    public TryCount(String input) {
        this.value = validatedInput(input);
    }

    public int validatedInput(String input) {
        try {
            int number = Integer.parseInt(input);
            checkIfUnderEndLine(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIfUnderEndLine(int number) {
        if (number < Constants.END_LINE) {
            throw new IllegalArgumentException();
        }
    }

    public void consume() {
        value--;
    }

    public boolean untilEndLine() {
        return value > Constants.END_LINE;
    }

    public int getValue() {
        return value;
    }
}
