package stringcalculator.domain;

import stringcalculator.Utils;

public class Number {
    private int number;

    protected Number(String input) {
        validateNonNumericInput(input);
        validateNegativeNumber(input);
        this.number = Integer.parseInt(input);
    }

    public int getNumber() {
        return number;
    }

    private void validateNonNumericInput(String input) {
        if(!Utils.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegativeNumber(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
